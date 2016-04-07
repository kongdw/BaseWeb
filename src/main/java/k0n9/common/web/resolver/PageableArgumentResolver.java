package k0n9.common.web.resolver;

import com.google.common.collect.Lists;
import k0n9.common.entity.search.domain.PageRequest;
import k0n9.common.entity.search.domain.Pageable;
import k0n9.common.entity.search.domain.Sort;
import k0n9.common.web.bind.PageableDefaults;
import net.sourceforge.stripes.controller.ExecutionContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Pageable 解析器
 * @author David Kong
 * @version 1.0
 */
public class PageableArgumentResolver extends BaseArgumentResolver {

    private static final Pageable DEFAULT_PAGE_REQUEST = new PageRequest(0, 10);
    private static final String DEFAULT_PAGE_PREFIX = "page";
    private static final String DEFAULT_SORT_PREFIX = "sort";

    private String pagePrefix = DEFAULT_PAGE_PREFIX;
    private String sortPrefix = DEFAULT_SORT_PREFIX;

    private int minPageSize = 5;
    private int maxPageSize = 100;

    /**
     * 设置最小分页大小 默认10
     *
     * @param minPageSize
     */
    public void setMinPageSize(int minPageSize) {
        this.minPageSize = minPageSize;
    }

    /**
     * 设置最大分页大小 默认100
     *
     * @param maxPageSize
     */
    public void setMaxPageSize(int maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    /**
     * Setter to configure the prefix of request parameters to be used to retrieve paging information. Defaults to
     * {@link #DEFAULT_PAGE_PREFIX}.
     *
     * @param pagePrefix the prefix to set
     */
    public void setPagePrefix(String pagePrefix) {
        this.pagePrefix = null == pagePrefix ? DEFAULT_PAGE_PREFIX : pagePrefix;
    }

    public void setSortPrefix(String sortPrefix) {
        this.sortPrefix = null == sortPrefix ? DEFAULT_SORT_PREFIX : sortPrefix;
    }

    public String getPagePrefix() {
        return pagePrefix;
    }

    public String getSortPrefix() {
        return sortPrefix;
    }

    @Override
    public Object resolveArgument(ExecutionContext executionContext) {
        HttpServletRequest request = executionContext.getActionBeanContext().getRequest();
        Method handler = executionContext.getHandler();

        PageableDefaults pageableDefaults = handler.getAnnotation(PageableDefaults.class);
        Pageable defaultPageRequest = defaultPageable(pageableDefaults);

        Map<String, String[]> pageableMap = getPrefixParameterMap(getPagePrefix(), request, true);
        Map<String, String[]> sortMap = getPrefixParameterMap(getSortPrefix(), request, false);


        Sort sort = getSort(getSortPrefix(), sortMap, defaultPageRequest, request);
        if (pageableMap.size() == 0) {
            return new PageRequest(defaultPageRequest.getPageNumber(), defaultPageRequest.getPageSize(), sort == null ? defaultPageRequest.getSort() : sort);
        }

        int pn = getPn(pageableMap, defaultPageRequest);
        int pageSize = getPageSize(pageableMap, defaultPageRequest);

        return new PageRequest(pn, pageSize, sort);
    }

    /**
     * 防止sql注入，排序字符串只能包含字符 数字 下划线 点 ` "
     *
     * @param property
     */
    private void assertSortProperty(String property) {
        if (!property.matches("[a-zA-Z0-9_、.`\"]*")) {
            throw new IllegalStateException("Sort property error, only contains [a-zA-Z0-9_.`\"]");
        }
    }

    private int getPageSize(Map<String, String[]> pageableMap, Pageable defaultPageRequest) {
        int pageSize = 0;
        try {
            String pageSizeStr = pageableMap.get("size")[0];
            if (pageSizeStr != null) {
                pageSize = Integer.valueOf(pageSizeStr);
            } else {
                pageSize = defaultPageRequest.getPageSize();
            }
        } catch (Exception e) {
            pageSize = defaultPageRequest.getPageSize();
        }

        if (pageSize < minPageSize) {
            pageSize = minPageSize;
        }

        if (pageSize > maxPageSize) {
            pageSize = maxPageSize;
        }
        return pageSize;
    }

    private int getPn(Map<String, String[]> pageableMap, Pageable defaultPageRequest) {
        int pn = 1;
        try {
            String pnStr = pageableMap.get("pn")[0];
            if (pnStr != null) {
                pn = Integer.valueOf(pnStr);
            } else {
                pn = defaultPageRequest.getPageNumber();
            }
        } catch (Exception e) {
            pn = defaultPageRequest.getPageNumber();
        }

        if (pn < 1) {
            pn = 1;
        }

        return pn;
    }

    private Pageable defaultPageable(PageableDefaults pageableDefaults) {

        if (pageableDefaults == null) {
            return null;
        }

        int pageNumber = pageableDefaults.pageNumber();
        int pageSize = pageableDefaults.value();

        String[] sortStrArray = pageableDefaults.sort();
        Sort sort = null;

        for (String sortStr : sortStrArray) {
            String[] sortStrPair = sortStr.split("=");
            Sort newSort = new Sort(Sort.Direction.fromString(sortStrPair[1]), sortStrPair[0]);
            if (sort == null) {
                sort = newSort;
            } else {
                sort = sort.and(newSort);
            }
        }
        return new PageRequest(pageNumber, pageSize, sort);
    }

    private Sort getSort(String sortNamePrefix, Map<String, String[]> sortMap, Pageable defaultPageRequest, HttpServletRequest request) {
        Sort sort = null;
        List<OrderedSort> orderedSortList = Lists.newArrayList();
        for (String name : sortMap.keySet()) {

            //sort1.abc
            int propertyIndex = name.indexOf(".") + 1;

            int order = 0;
            String orderStr = name.substring(sortNamePrefix.length(), propertyIndex - 1);
            try {
                if (!StringUtils.isEmpty(orderStr)) {
                    order = Integer.valueOf(orderStr);
                }
            } catch (Exception e) {
            }

            String property = name.substring(propertyIndex);
            assertSortProperty(property);
            Sort.Direction direction = Sort.Direction.fromString(sortMap.get(name)[0]);

            orderedSortList.add(new OrderedSort(property, direction, order));
        }

        Collections.sort(orderedSortList);
        for (OrderedSort orderedSort : orderedSortList) {
            Sort newSort = new Sort(orderedSort.direction, orderedSort.property);
            if (sort == null) {
                sort = newSort;
            } else {
                sort = sort.and(newSort);
            }
        }

        if (sort == null) {
            return defaultPageRequest.getSort();
        }

        return sort;
    }

    static class OrderedSort implements Comparable<OrderedSort> {
        private String property;
        private Sort.Direction direction;
        private int order = 0; //默认0 即无序

        OrderedSort(String property, Sort.Direction direction, int order) {
            this.property = property;
            this.direction = direction;
            this.order = order;
        }

        @Override
        public int compareTo(OrderedSort o) {
            if (o == null) {
                return -1;
            }
            if (this.order > o.order) {
                return 1;
            } else if (this.order < o.order) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

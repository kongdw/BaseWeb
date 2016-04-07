package k0n9.common.web.resolver;

import com.google.common.collect.Lists;
import k0n9.common.entity.search.Searchable;
import k0n9.common.entity.search.domain.Pageable;
import k0n9.common.utils.CollectionUtils;
import k0n9.common.web.bind.SearchableDefaults;
import net.sourceforge.stripes.controller.ExecutionContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Searchable 解析器
 *
 * @author David Kong
 * @version 1.0
 */
public class SearchableArgumentResolver extends BaseArgumentResolver {
    private static final PageableArgumentResolver DEFAULT_PAGEABLE_RESOLVER = new PageableArgumentResolver();
    private static final String DEFAULT_SEARCH_PREFIX = "search";

    private String prefix = DEFAULT_SEARCH_PREFIX;

    @Override
    public Object resolveArgument(ExecutionContext executionContext) {
        HttpServletRequest request = executionContext.getActionBeanContext().getRequest();
        Method method = executionContext.getHandler();
        SearchableDefaults searchDefaults = getSearchableDefaults(method);
        Map<String, String[]> searcheableMap = getPrefixParameterMap(getPrefix(),request , true);

        boolean hasCustomSearchFilter = searcheableMap.size() > 0;
        boolean needMergeDefault = searchDefaults != null && searchDefaults.merge();

        Searchable searchable = null;
        //自定义覆盖默认
        if (needMergeDefault || !hasCustomSearchFilter) {
            searchable = getDefaultFromAnnotation(searchDefaults);
        }
        if (hasCustomSearchFilter) {
            if (searchable == null) {
                searchable = Searchable.newSearchable();
            }
            for (String name : searcheableMap.keySet()) {
                String[] mapValues = filterSearchValues(searcheableMap.get(name));

                if (mapValues.length == 1) {
                    if (name.endsWith("in")) {
                        searchable.addSearchParam(name, StringUtils.split(mapValues[0], ",; "));
                    } else {
                        searchable.addSearchParam(name, mapValues[0]);
                    }
                } else {
                    searchable.addSearchParam(name, mapValues);
                }
            }
        }

        Pageable pageable = (Pageable) pageableMethodArgumentResolver.resolveArgument(executionContext);
        //默认分页及排序
        if (searchDefaults == null) {
            searchable.setPage(pageable);
        }
        //needPage=true 分页及排序
        if (searchDefaults != null && searchDefaults.needPage()) {
            searchable.setPage(pageable);
        }
        //needPage=false needSort=true  不要分页，但排序
        if (searchDefaults != null && !searchDefaults.needPage() && searchDefaults.needSort()) {
            searchable.addSort(pageable.getSort());
        }

        return searchable;
    }
    /**
     * 设置查询参数前缀
     *
     * @param prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    /**
     * 分页参数解析器
     */
    private PageableArgumentResolver pageableMethodArgumentResolver = DEFAULT_PAGEABLE_RESOLVER;

    public void setPageableMethodArgumentResolver(PageableArgumentResolver pageableMethodArgumentResolver) {
        this.pageableMethodArgumentResolver = pageableMethodArgumentResolver;
    }

    private String[] filterSearchValues(String[] values) {
        List<String> result = Lists.newArrayList(CollectionUtils.arrayToList(values));
        for (int i = 0; i < result.size(); i++) {
            if (StringUtils.isBlank(result.get(i))) {
                result.remove(i);
            }
        }
        return result.toArray(values);
    }
    private SearchableDefaults getSearchableDefaults(Method method) {
        return method.getAnnotation(SearchableDefaults.class);
    }

    private Searchable getDefaultFromAnnotation(SearchableDefaults searchableDefaults) {

        Searchable searchable = defaultSearchable(searchableDefaults);
        if (searchable != null) {
            return searchable;
        }

        return Searchable.newSearchable();
    }

    private Searchable defaultSearchable(SearchableDefaults searchableDefaults) {

        if (searchableDefaults == null) {
            return null;
        }

        Searchable searchable = Searchable.newSearchable();
        for (String searchParam : searchableDefaults.value()) {
            String[] searchPair = searchParam.split("=");
            String paramName = searchPair[0];
            String paramValue = searchPair[1];
            if (paramName.endsWith("in")) {
                searchable.addSearchParam(paramName, StringUtils.split(paramValue, ",; "));
            } else {
                searchable.addSearchParam(paramName, paramValue);
            }
        }

        return searchable;
    }
}

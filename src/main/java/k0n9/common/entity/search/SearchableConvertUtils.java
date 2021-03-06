package k0n9.common.entity.search;

import com.google.common.collect.Lists;
import k0n9.common.entity.search.exception.InvalidSearchPropertyException;
import k0n9.common.entity.search.exception.InvalidSearchValueException;
import k0n9.common.entity.search.filter.AndCondition;
import k0n9.common.entity.search.filter.Condition;
import k0n9.common.entity.search.filter.OrCondition;
import k0n9.common.entity.search.filter.SearchFilter;
import k0n9.common.utils.ObjectUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Kong
 * @version 1.0
 */
public class SearchableConvertUtils {

    static {
        DateConverter dc = new DateConverter();
        dc.setUseLocaleFormat(true);
        dc.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
        org.apache.commons.beanutils.ConvertUtils.register(dc, Date.class);
    }

    public static <T> void convertSearchValueToEntityValue(SearchRequest searchRequest, Class<T> entityClass) {
        if (searchRequest.isConverted()) {
            return;
        }
        Collection<SearchFilter> searchFilters = searchRequest.getSearchFilters();

        for (SearchFilter filter : searchFilters) {
            convertSearchValueToEntityValue(entityClass, filter);
        }
    }

    private static <T> void convertSearchValueToEntityValue(Class<T> entityClass, SearchFilter searchFilter) {
        if (searchFilter instanceof Condition) {
            Condition condition = (Condition) searchFilter;
            convert(entityClass, condition);
        }
        if (searchFilter instanceof OrCondition) {
            for (SearchFilter orFilter : ((OrCondition) searchFilter).getOrFilters()) {
                convertSearchValueToEntityValue(entityClass, orFilter);
            }
            return;
        }

        if (searchFilter instanceof AndCondition) {
            for (SearchFilter andFilter : ((AndCondition) searchFilter).getAndFilters()) {
                convertSearchValueToEntityValue(entityClass, andFilter);
            }
            return;
        }
    }

    private static <T> void convert(Class<T> entityClass, Condition condition) {
        String searchProperty = condition.getSearchProperty();

        String searchColumn = getConvertedSearchColumn(condition.getSearchProperty(), entityClass);
        condition.setSearchColumn(searchColumn);

        if (condition.getOperator() == SearchOperator.custom) {
            return;
        }

        if (condition.isUnaryFilter()) {
            return;
        }

        String entityProperty = condition.getEntityProperty();
        Object value = condition.getValue();
        Object newValue = null;
        boolean isCollection = value instanceof Collection;
        boolean isArray = value != null && value.getClass().isArray();
        if (isCollection || isArray) {
            List<Object> list = Lists.newArrayList();
            if (isCollection) {
                list.addAll((Collection) value);
            } else {
                list = Lists.newArrayList(Arrays.asList(ObjectUtils.toObjectArray(value)));
            }
            int length = list.size();
            for (int i = 0; i < length; i++) {
                list.set(i, getConvertedValue(entityClass, searchProperty, entityProperty, list.get(i)));
            }
            newValue = list;
        } else {
            newValue = getConvertedValue(entityClass, searchProperty, entityProperty, value);
        }
        condition.setValue(newValue);
    }

    /**
     * 转换字符串到相应类型.
     */
    private static Object getConvertedValue(final Class entityClass, final String searchProperty, final String entityProperty, final Object value) {
        Class returnType;
        Method method = null;
        if (value == null) {
            return null;
        }
        String[] namesSplits = StringUtils.split(entityProperty, ".");
        if (namesSplits.length == 1) {
            method = MethodUtils.getAccessibleMethod(entityClass, "get" + StringUtils.capitalize(entityProperty));
        } else {
            Class<?> retClass = entityClass;
            for (String nameSplit : namesSplits) {
                method = MethodUtils.getAccessibleMethod(retClass, "get" + StringUtils.capitalize(nameSplit));
                retClass = method.getReturnType();
            }
        }
        if (method == null) {
            throw new InvalidSearchPropertyException(searchProperty, entityProperty);
        }
        returnType = method.getReturnType();
        try {
            return org.apache.commons.beanutils.ConvertUtils.convert(value, returnType);
        } catch (Exception e) {
            throw new InvalidSearchValueException(searchProperty, entityProperty, value);
        }
    }

    public static String camelhumpToUnderline(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() + i, matcher.end() + i, "_" + matcher.group().toLowerCase());
        }
        if (builder.charAt(0) == '_') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }


    public static String getConvertedSearchColumn(String property, Class<?> clazz) {
        String[] namesSplits = StringUtils.split(property, ".");
        Field field = null;
        String columnName = "";
        String tableName = "";
        Class entityClass = clazz;
        for (String namesSplit : namesSplits) {
            field = FieldUtils.getField(entityClass, namesSplit, true);
            entityClass = field.getType();
        }
        if (field != null) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                columnName = column.name();
            } else {
                columnName = camelhumpToUnderline(field.getName());
            }
            Class<?> fieldClass = field.getDeclaringClass();
            Table table = fieldClass.getAnnotation(Table.class);
            if (table != null) {
                tableName = table.name();
            } else {
                tableName = camelhumpToUnderline(fieldClass.getSimpleName());
            }
        }
        return tableName + "." + columnName;
    }
}

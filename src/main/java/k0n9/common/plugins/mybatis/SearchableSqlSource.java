package k0n9.common.plugins.mybatis;

import k0n9.common.entity.search.Searchable;
import k0n9.common.entity.search.domain.Pageable;
import k0n9.common.entity.search.domain.Sort;
import k0n9.common.entity.search.filter.AndCondition;
import k0n9.common.entity.search.filter.Condition;
import k0n9.common.entity.search.filter.OrCondition;
import k0n9.common.entity.search.filter.SearchFilter;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.session.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author David Kong
 * @version 1.0
 */
public class SearchableSqlSource implements SqlSource {

    private final Configuration configuration;
    private final String baseSql;

    public SearchableSqlSource(Configuration configuration, String baseSql) {
        this.configuration = configuration;
        this.baseSql = baseSql;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        DynamicContext context = new DynamicContext(configuration, parameterObject);
        Searchable searchable = getSearchable(parameterObject);
        if (searchable == null) {
            throw new UnsupportedOperationException("设置SearchableLanguageDriver 必须传递一个Searchable对象");
        }
        context.appendSql(baseSql);
        apply(context, searchable);
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> parameterType = parameterObject.getClass();
        SqlSource sqlSource = sqlSourceParser.parse(context.getSql(), parameterType, context.getBindings());
        BoundSql boundSql = sqlSource.getBoundSql(parameterObject);
        for (Map.Entry<String, Object> entry : context.getBindings().entrySet()) {
            boundSql.setAdditionalParameter(entry.getKey(), entry.getValue());
        }
        return boundSql;
    }

    private void apply(DynamicContext context, Searchable searchable) {
        if (searchable.hasSearchFilter()) {
            for (SearchFilter filter : searchable.getSearchFilters()) {
                context.appendSql(" AND ");
                parserSql(context, filter);
            }
        }
        if (searchable.hasSort()) {
            for (Sort.Order order : searchable.getSort()) {
                context.appendSql(order.getProperty() + " " + order.getDirection());
            }
        }

        if (searchable.hasPageable()) {
            Pageable pageable = searchable.getPage();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" LIMIT ");
            if (pageable.getOffset() > 0) {
                stringBuilder.append(pageable.getOffset()).append(",").append(pageable.getPageSize());
            } else {
                stringBuilder.append(pageable.getPageSize());
            }
            context.appendSql(stringBuilder.toString());
        }
    }

    private void parserSql(DynamicContext context, SearchFilter searchFilter) {
        boolean needAppendBracket = searchFilter instanceof OrCondition || searchFilter instanceof AndCondition;
        if (needAppendBracket) {
            context.appendSql("(");
        }
        if (searchFilter instanceof Condition) {
            Condition condition = (Condition) searchFilter;
            String searchColumn = condition.getSearchColumn();
            String operatorStr = condition.getOperatorStr();
            context.appendSql(searchColumn);
            context.appendSql(operatorStr);
            if (!condition.isUnaryFilter()) {
                parserParameter(context, condition);
            }
        } else if (searchFilter instanceof OrCondition) {
            boolean isFirst = true;
            for (SearchFilter orSearchFilter : ((OrCondition) searchFilter).getOrFilters()) {
                if (!isFirst) {
                    context.appendSql(" OR ");
                }
                parserSql(context, orSearchFilter);
                isFirst = false;
            }
        } else if (searchFilter instanceof AndCondition) {
            boolean isFirst = true;
            for (SearchFilter andSearchFilter : ((AndCondition) searchFilter).getAndFilters()) {
                if (!isFirst) {
                    context.appendSql(" AND ");
                }
                parserSql(context, andSearchFilter);
                isFirst = false;
            }
        }
        if (needAppendBracket) {
            context.appendSql(")");
        }
    }

    private void parserParameter(DynamicContext context, Condition condition) {
        switch (condition.getOperator()) {
            case in:
            case notIn: {
                context.appendSql("(");
                if (condition.getValue() instanceof List) {
                    List<Object> items = (List) condition.getValue();
                    for (int i = 0; i < items.size(); i++) {
                        String key = condition.getKey() + "_" + context.getUniqueNumber();
                        context.bind(key, items.get(i));
                        context.appendSql("#{");
                        context.appendSql(key);
                        context.appendSql("}");
                        if (i != items.size() - 1) {
                            context.appendSql(",");
                        }
                    }
                }
                context.appendSql(")");
                break;
            }
            case like:
            case notLike: {
                String key = condition.getKey() + "_" + context.getUniqueNumber();
                context.appendSql("#{");
                context.appendSql(key);
                context.appendSql("}");
                context.bind(key, "%" + condition.getValue() + "%");
                break;
            }
            case suffixLike:
            case suffixNotLike: {
                String key = condition.getKey() + "_" + context.getUniqueNumber();
                context.appendSql("#{");
                context.appendSql(key);
                context.appendSql("}");
                context.bind(key, "%" + condition.getValue());
                break;
            }
            case prefixLike:
            case prefixNotLike: {
                String key = condition.getKey() + "_" + context.getUniqueNumber();
                context.appendSql("#{");
                context.appendSql(key);
                context.appendSql("}");
                context.bind(key, condition.getValue() + "%");
                break;
            }
            default: {
                String key = condition.getKey() + "_" + context.getUniqueNumber();
                context.appendSql("#{");
                context.appendSql(key);
                context.appendSql("}");
                context.bind(key, condition.getValue());
            }
        }
    }


    private Searchable getSearchable(Object objectParameter) {
        if (objectParameter instanceof Map) {
            Map<String, Object> parametersMap = (Map<String, Object>) objectParameter;
            for (Map.Entry<String, Object> param : parametersMap.entrySet()) {
                if (param.getValue() instanceof Searchable) {
                    return (Searchable) param.getValue();
                }
            }
        }
        if (objectParameter instanceof Searchable) {
            return (Searchable) objectParameter;
        }
        return null;
    }
}

package k0n9.common.plugins.mybatis;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import k0n9.common.entity.search.Searchable;
import k0n9.common.entity.search.domain.Pageable;
import k0n9.common.plugins.mybatis.util.PatternMatchUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

/**
 * @author David Kong
 * @version 1.0
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ExecutorInterceptor implements Interceptor {

    private Logger log = LoggerFactory.getLogger(ExecutorInterceptor.class);

    private String pagingSqlIdRegex;
    private int pageSize;

    @Inject
    public ExecutorInterceptor(@Named("stmtIdRegex") String pagingSqlIdRegex, @Named("pageSize") int pageSize) {
        this.pagingSqlIdRegex = pagingSqlIdRegex;
        this.pageSize = pageSize;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] objects = invocation.getArgs();
        MappedStatement oldMappedStatement = (MappedStatement) objects[0];
        boolean intercept = PatternMatchUtils.simpleMatch(pagingSqlIdRegex, oldMappedStatement.getId());
        if (intercept) {
            Object parameterObject = objects[1];
            Searchable searchable = getSearchable(parameterObject);
            if (searchable != null) {
                log.info("ExecutorIntercept Plug-in intercepted mappedStatement id {}.", oldMappedStatement.getId());
                invocation.getArgs()[2] = getRowBounds(searchable.getPage());
            }
        }
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

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

    private RowBounds getRowBounds(Pageable pageable) {
        if (pageable == null) {
            return new RowBounds(RowBounds.NO_ROW_OFFSET, pageSize);
        }
        return new RowBounds(pageable.getOffset(), pageable.getPageSize());
    }
}

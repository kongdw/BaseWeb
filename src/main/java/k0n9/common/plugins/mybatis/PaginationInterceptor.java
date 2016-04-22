package k0n9.common.plugins.mybatis;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import k0n9.common.plugins.mybatis.dialect.Dialect;
import k0n9.common.plugins.mybatis.helper.DialectHelper;
import k0n9.common.plugins.mybatis.helper.SqlHelper;
import k0n9.common.plugins.mybatis.util.PatternMatchUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author DavidKong
 * @version 2.0
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationInterceptor implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private static final ThreadLocal<Integer> PAGINATION_TOTAL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private Dialect dialect;
    private String pagingSqlIdRegex;

    @Inject
    public PaginationInterceptor(@Named("dialect") String dialectStr, @Named("stmtIdRegex") String pagingSqlIdRegex) {
        this.pagingSqlIdRegex = pagingSqlIdRegex;
        Dialect.Type databaseType = null;
        try {
            databaseType = Dialect.Type.valueOf(dialectStr.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null == databaseType) {
            throw new RuntimeException(
                    "Plug-in [PaginationInterceptor] the dialect of the attribute value is invalid! Valid values for:"
                            + getDialectTypeValidValues());
        }
        this.dialect = DialectHelper.getDialect(databaseType);
    }

    /**
     * Get Pagination total
     *
     * @return
     */
    public static int getPaginationTotal() {
        int count = PAGINATION_TOTAL.get();
        PaginationInterceptor.clean();
        return count;
    }

    public static void clean() {
        PAGINATION_TOTAL.remove();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();

        boolean intercept = PatternMatchUtils.simpleMatch(pagingSqlIdRegex, mappedStatement.getId());
        if (intercept && dialect.supportsLimit()
                && (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {

            BoundSql boundSql = statementHandler.getBoundSql();
            Object parameterObject = boundSql.getParameterObject();
            Connection connection = (Connection) invocation.getArgs()[0];
            int count = SqlHelper.getCount(mappedStatement, connection, parameterObject, dialect);
            PAGINATION_TOTAL.set(count);

            String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

            metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, offset, limit));
            metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
            metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
            logger.info("limit sql: {}", boundSql.getSql());
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialectClass = properties.getProperty("dialectClass");
        if (StringUtils.isBlank(dialectClass)) {
            Dialect.Type databaseType = null;
            try {
                databaseType = Dialect.Type.valueOf(properties.getProperty("dialect").toUpperCase());
            } catch (Exception e) {
            }

            if (null == databaseType) {
                throw new RuntimeException(
                        "Plug-in [PaginationInterceptor] the dialect of the attribute value is invalid! Valid values for:"
                                + getDialectTypeValidValues());
            }
            dialect = DialectHelper.getDialect(databaseType);
        } else {
            try {
                dialect = (Dialect) Class.forName(dialectClass).newInstance();
            } catch (Exception e) {
                throw new RuntimeException(
                        "Plug-in [PaginationInterceptor] cannot create dialect instance by dialectClass: "
                                + dialectClass);
            }
        }
        pagingSqlIdRegex = properties.getProperty("stmtIdRegex", "*.findPage*");
    }

    private String getDialectTypeValidValues() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Dialect.Type.values().length; i++) {
            sb.append(Dialect.Type.values()[i].name()).append(",");
        }
        return sb.toString();
    }
}

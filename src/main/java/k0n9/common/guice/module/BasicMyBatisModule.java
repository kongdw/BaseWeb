package k0n9.common.guice.module;

import k0n9.common.plugins.mybatis.PaginationInterceptor;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

/**
 * @author David Kong
 * @version 1.0
 */
public class BasicMyBatisModule extends MyBatisModule {

    @Override
    protected void initialize() {
        //Names.bindProperties(binder(), new HashMap<String, String>() {
        //    private static final long serialVersionUID = 8194640490044636788L;
        //    {
			//	/* JDBC and MyBatis */
        //        put("JDBC.url", "jdbc:h2:tcp://localhost:9092/web");
        //        put("JDBC.username", "sa");
        //        put("JDBC.password", "");
        //        put("JDBC.driver", "org.h2.Driver");
        //        put("mybatis.environment.id", "ds");
        //        // JDBC.autoCommit -- boolean
        //        // JDBC.loginTimeout -- int
        //        // JDBC.driverProperties -- java.util.Properties
        //        // mybatis.pooled.maximumActiveConnections -- int
        //        // mybatis.pooled.maximumCheckoutTime -- int
        //        // mybatis.pooled.maximumIdleConnections -- int
        //        // mybatis.pooled.pingConnectionsNotUsedFor -- int
        //        // mybatis.pooled.pingEnabled -- boolean
        //        // mybatis.pooled.pingQuery -- String
        //        // mybatis.pooled.timeToWait -- int
        //        put("dialect","mysql");
        //        put("stmtIdRegex","*.findPage*");
        //    }
        //});
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        useCacheEnabled(true);
        addMapperClasses("k0n9.module.sys.dao");
        addSimpleAliases("k0n9.module.sys.entity");
        addMapperClasses("k0n9.module.archive.dao");
        addSimpleAliases("k0n9.module.archive.entity");
        addInterceptorClass(PaginationInterceptor.class);
    }
}

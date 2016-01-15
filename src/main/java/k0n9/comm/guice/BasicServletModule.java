package k0n9.comm.guice;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import k0n9.comm.servlet.HsqlDbSetupServlet;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.DynamicMappingFilter;
import net.sourceforge.stripes.controller.StripesFilter;

import java.util.HashMap;

public class BasicServletModule extends ServletModule {

	@Override
	protected void configureServlets() {

		// init hsql
		bind(HsqlDbSetupServlet.class).in(Singleton.class);
		serve("/hidden/setup").with(HsqlDbSetupServlet.class);

		bind(DispatcherServlet.class).in(Singleton.class);
		serve("*.action").with(DispatcherServlet.class);

		bind(StripesFilter.class).in(Singleton.class);
		filter("*.jsp").through(StripesFilter.class, new HashMap<String, String>() {
            private static final long serialVersionUID = 5833014702903316408L;
            {
				put("ActionResolver.Packages", "k0n9.module.sys.web,k0n9.module.showcase");
				put("Extension.Packages", "k0n9.module.sys.web.extensions");
				put("Stripes.EncryptionKey", "kongdewen");
				put("PopulationStrategy.Class", "net.sourceforge.stripes.tag.BeanFirstPopulationStrategy");
				put("Configuration.Class", "com.silvermindsoftware.sg.config.GuiceRuntimeConfiguration");
				put("ActionBeanContextFactory.Class", "com.silvermindsoftware.sg.controller.GuiceActionBeanContextFactory");
				put("ActionResolver.Class", "com.silvermindsoftware.sg.controller.GuiceActionResolver");
				put("FileUpload.MaximumPostSize", "50mb");
			}
		});

		bind(DynamicMappingFilter.class).in(Singleton.class);
		filter("/*").through(DynamicMappingFilter.class);
	}
}

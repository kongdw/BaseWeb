package k0n9.common.guice.module;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import k0n9.common.web.servlet.HsqlDbSetupServlet;
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
				put("ActionResolver.Packages", "k0n9.module.sys.web,k0n9.module.archive.web,k0n9.common.web");
				put("Extension.Packages", "k0n9.common.plugins.stripes.extensions");
				put("Stripes.EncryptionKey", "kongdewen");
				put("PopulationStrategy.Class", "net.sourceforge.stripes.tag.BeanFirstPopulationStrategy");
				put("Configuration.Class", "k0n9.common.guice.config.GuiceRuntimeConfiguration");
				put("ActionBeanContextFactory.Class", "k0n9.common.guice.controller.GuiceActionBeanContextFactory");
				put("ActionResolver.Class", "k0n9.common.guice.controller.GuiceActionResolver");
                put("ActionBeanPropertyBinder.Class","k0n9.common.plugins.stripes.controller.DefaultActionBeanPropertyBinder");
				put("FileUpload.MaximumPostSize", "50mb");
                put("LocalePicker.Locales","zh_CN:UTF-8");
			}
		});

		bind(DynamicMappingFilter.class).in(Singleton.class);
		filter("/*").through(DynamicMappingFilter.class);
	}
}

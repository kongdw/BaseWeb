package k0n9.comm.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class BasicWebAppGuiceServletContextListener extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
                new ApplicationConfiguration(),
                new BasicMyBatisModule(),
                new BasicServletModule()
        );
	}
}

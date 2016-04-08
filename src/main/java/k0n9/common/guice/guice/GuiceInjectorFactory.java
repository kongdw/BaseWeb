package k0n9.common.guice.guice;

import com.google.inject.Injector;

import javax.servlet.ServletContext;

/**
 * @author David Kong
 * @version 1.0
 */
public interface GuiceInjectorFactory {
    Injector getInjector(ServletContext aServletContext);
}

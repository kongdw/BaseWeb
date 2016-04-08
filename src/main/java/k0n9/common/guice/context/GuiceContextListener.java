package k0n9.common.guice.context;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import k0n9.common.guice.guice.GuiceInjectorFactory;
import k0n9.common.guice.utils.Constants;
import k0n9.common.guice.utils.Helpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * <p>
 * The following can be added to the web.xml in order to use the
 * {@link GuiceContextListener
 * GuiceContextListener}. Just replace the GuiceModules param-value with a
 * comma-delimited list of Modules you want to initialize.
 * </p>
 * <p/>
 * <code>
 * &lt;listener&gt;<br/>
 * &nbsp;&nbsp;&lt;listener-class&gt;<br/>
 * &nbsp;&nbsp;&nbsp;&nbsp;com.silvermindsoftware.sg.context.GuiceContextListener<br/>
 * &nbsp;&nbsp;&lt;/listener-class&gt;<br/>
 * &lt;/listener&gt;<br/>
 * </code>
 * <p/>
 * <br/>
 * <p/>
 * <code>
 * &lt;context-param&gt;<br/>
 * &nbsp;&nbsp;&lt;param-name&gt;Guice.Modules&lt;/param-name&gt;<br/>
 * &nbsp;&nbsp;&lt;param-value&gt;fully-qualified-module-class-name[[,fully-qualified-module-class-name]... ]&lt;/param-value&gt;<br/>
 * &lt;/context-param&gt;<br/>
 * </code>
 * <p/>
 * <p>
 * Alternate functionality can be provided for creating the Injector. Simply
 * implement the
 * {@link GuiceInjectorFactory
 * DefaultGuiceInjectorFactory} and specify it in an context-param:
 * </p>
 * <p/>
 * <code>
 * &lt;context-param&gt;<br/>
 * &nbsp;&nbsp;&lt;param-name&gt;GuiceInjectorFactory.Class&lt;/param-name&gt;<br/>
 * &nbsp;&nbsp;&lt;param-value&gt;fully-qualified-class-name&lt;/param-value&gt;<br/>
 * &lt;/context-param&gt;<br/>
 * </code>
 */
public class GuiceContextListener extends GuiceServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuiceContextListener.class);
    private ServletContext theServletContext;

    @Override
    public void contextInitialized(ServletContextEvent aServletContextEvent) {
        theServletContext = aServletContextEvent.getServletContext();
        super.contextInitialized(aServletContextEvent);
    }

    @Override
    protected Injector getInjector() {
        LOGGER.debug("Creating Injector");

        final String myClassname = getGuiceInjectorFactoryClassName(theServletContext);
        final GuiceInjectorFactory myFactory = Helpers.createClass(myClassname, GuiceInjectorFactory.class);

        return myFactory.getInjector(theServletContext);
    }

    private String getGuiceInjectorFactoryClassName(ServletContext aServletcontext) {
        final String myClassname = aServletcontext.getInitParameter(Constants.GUICE_INJECTOR_FACTORY_CLASS_NAME);
        return Helpers.isEmptyOrNull(myClassname) ? Constants.DEFAULT_GUICE_INJECTOR_FACTORY_CLASS_NAME : myClassname;
    }
}

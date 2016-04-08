package k0n9.common.guice.config;

import com.google.common.collect.Maps;
import com.google.inject.Injector;
import k0n9.common.guice.utils.Helpers;
import net.sourceforge.stripes.config.ConfigurableComponent;
import net.sourceforge.stripes.config.RuntimeConfiguration;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.exception.StripesRuntimeException;

import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author David Kong
 * @version 1.0
 */
public class GuiceRuntimeConfiguration extends RuntimeConfiguration {
    @Override
    protected <T extends ConfigurableComponent> T initializeComponent(Class<T> aComponentType,
                                                                      String aPropertyName) {
        final Class myClass = getBootstrapPropertyResolver().getClassProperty(aPropertyName, aComponentType);
        if (myClass != null) {
            try {
                @SuppressWarnings("unchecked")
                final Object myInstance = getInjectorFromContext().getInstance(myClass);
                final T myComponent = aComponentType.cast(myInstance);
                myComponent.init(this);
                return myComponent;
            } catch (Exception myException) {
                throw new StripesRuntimeException("Could not instantiate configured "
                        + aComponentType.getSimpleName() + " of type ["
                        + myClass.getSimpleName()
                        + "]. Please check "
                        + "the configuration parameters specified in your web.xml.",
                        myException);
            }
        } else {
            return null;
        }
    }

    @Override
    protected Map<LifecycleStage, Collection<Interceptor>> initInterceptors(List aClasses) {
        final Map<LifecycleStage, Collection<Interceptor>> myInterceptors = Maps.newHashMap();

        @SuppressWarnings("unchecked")
        final List<Class<Interceptor>> myInterceptorList = (List<Class<Interceptor>>) aClasses;
        for (Class<Interceptor> myType : myInterceptorList) {
            try {
                final Interceptor myInterceptor = getInjectorFromContext().getInstance(myType);
                addInterceptor(myInterceptors, myInterceptor);
            } catch (Exception myException) {
                throw new StripesRuntimeException("Could not instantiate configured Interceptor", myException);
            }
        }

        return myInterceptors;
    }

    private Injector getInjectorFromContext() {
        final ServletContext myServletContext = getServletContext();
        return Helpers.getInjector(myServletContext);
    }
}
package k0n9.common.guice.utils;

import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;

import static k0n9.common.guice.exception.CreateClassException.createException;
import static k0n9.common.guice.utils.Constants.GUICE_MODULES_PARAM;
/**
 * @author David Kong
 * @version 1.0
 */
public enum Helpers {
    ;
    private static final Logger LOGGER = LoggerFactory.getLogger(Helpers.class);

    public static <T> T createClass(String aClassName,Class<T> aTargetType) {
        try {
            return aTargetType.cast(Class.forName(aClassName.trim()).newInstance());
        } catch (Exception myException) {
            LOGGER.error("Exception when creating class", myException);
            throw createException(myException, aClassName);
        }
    }

    public static boolean isEmptyOrNull(String aClassName) {
        return aClassName == null || aClassName.trim().isEmpty();
    }

    public static String[] getModuleNames(ServletContext aServletContext) {
        final String myGuiceModules = aServletContext.getInitParameter(GUICE_MODULES_PARAM);
        return splitClasses(myGuiceModules);
    }

    public static String[] splitClasses(String aModuleclasses) {
        return aModuleclasses != null ? aModuleclasses.split(",") : new String[0];
    }

    public static Injector getInjector(ServletContext aServletContext) {
        return Injector.class.cast(aServletContext.getAttribute(Injector.class.getName()));
    }
}
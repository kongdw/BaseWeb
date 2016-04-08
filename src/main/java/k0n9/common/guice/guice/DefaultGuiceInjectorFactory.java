package k0n9.common.guice.guice;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.util.List;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.Stage.DEVELOPMENT;
import static k0n9.common.guice.utils.Helpers.createClass;
import static k0n9.common.guice.utils.Helpers.getModuleNames;

/**
 * @author David Kong
 * @version 1.0
 */
public class DefaultGuiceInjectorFactory implements GuiceInjectorFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultGuiceInjectorFactory.class);
    private ServletContext theServletContext;

    
    public Injector getInjector( ServletContext aServletContext) {
        LOGGER.debug("Creating Injector");

        theServletContext = aServletContext;
        final List<Module> myModules = gatherModules();

        return createInjector(stage(), myModules);
    }

    
    protected ServletContext getServletContext() {
        return theServletContext;
    }

    
    protected Stage stage() {
        return DEVELOPMENT;
    }

    
    protected List<Module> createModules( String[] aModuleNames) {
        final List<Module> myModules = Lists.newArrayList();

        for (String myClassName : aModuleNames) {
            myModules.add(createClass(myClassName, Module.class));
        }

        return myModules;
    }

    
    protected List<Module> additionalModules() {
        return Lists.newArrayList();
    }

    
    private List<Module> gatherModules() {
        final List<Module> myModules = Lists.newArrayList();

        final String[] myModuleNames = getModuleNames(getServletContext());
        myModules.addAll(createModules(myModuleNames));
        myModules.addAll(additionalModules());

        return myModules;
    }
}
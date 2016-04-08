package k0n9.common.guice.controller;

import com.google.inject.Inject;
import com.google.inject.Injector;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.controller.ActionResolver;
import net.sourceforge.stripes.controller.NameBasedActionResolver;

/**
 * @author David Kong
 * @version 1.0
 */
public class GuiceActionResolver extends NameBasedActionResolver implements ActionResolver {

    private final Injector theInjector;

    @Inject
    public GuiceActionResolver(Injector anInjector) {
        theInjector = anInjector;
    }

    @Override
    protected ActionBean makeNewActionBean(Class<? extends ActionBean> aType, ActionBeanContext aContext) {
        return theInjector.getInstance(aType);
    }
}


package k0n9.common.web;

import k0n9.common.plugins.stripes.extensions.BaseActionBeanContext;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.HttpCache;

import javax.annotation.security.PermitAll;

/**
 * @author David Kong
 * @version 1.0
 */
@HttpCache(allow=false)
@PermitAll
public abstract class BaseActionBean implements ActionBean {

    private BaseActionBeanContext context;

    public void setContext(final ActionBeanContext context) {
        this.context = (BaseActionBeanContext) context;
    }

    public BaseActionBeanContext getContext() {
        return context;
    }

}

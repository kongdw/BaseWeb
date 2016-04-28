package k0n9.common.web;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseActionBean implements ActionBean {

    private ActionBeanContext context;

    public void setContext(final ActionBeanContext context) {
        this.context = context;
    }

    public ActionBeanContext getContext() {
        return context;
    }

}

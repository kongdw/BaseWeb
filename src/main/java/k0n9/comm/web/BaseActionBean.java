package k0n9.comm.web;

import k0n9.comm.entity.Persistable;
import k0n9.comm.service.BaseService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

import java.io.Serializable;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseActionBean<T extends Persistable, ID extends Serializable> implements ActionBean {

    private ActionBeanContext context;

    abstract protected BaseService<T, ID> getEntityService();

    public void setContext(final ActionBeanContext context) {
        this.context = context;
    }

    public ActionBeanContext getContext() {
        return context;
    }


}

package k0n9.common.web;

import k0n9.common.entity.Persistable;
import k0n9.common.entity.search.Searchable;
import k0n9.common.service.BaseService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

import java.io.Serializable;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseActionBean<T extends Persistable, ID extends Serializable> implements ActionBean {

    public static final String ADMIN_URL_PREFIX = "/WEB-INF/jsp/admin";

    public static final String FRONT_URL_PREFIX = "/WEB-INF/jsp/front";

    private ActionBeanContext context;

    /**
     * 标准查询接口，通过拦截器动态注入到ActionBean中。
     */
    private Searchable searchable;

    abstract protected BaseService<T, ID> getEntityService();

    public void setContext(final ActionBeanContext context) {
        this.context = context;
    }

    public ActionBeanContext getContext() {
        return context;
    }

    protected Searchable getSearchable() {
        return searchable;
    }

    protected void setSearchable(Searchable searchable) {
        this.searchable = searchable;
    }
}

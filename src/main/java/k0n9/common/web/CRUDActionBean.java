package k0n9.common.web;

import k0n9.common.entity.Persistable;
import k0n9.common.entity.search.Searchable;
import k0n9.common.entity.search.domain.Page;
import k0n9.common.service.BaseService;
import k0n9.common.web.resolver.SearchableArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class CRUDActionBean<T extends Persistable, ID extends Serializable> extends BaseActionBean {
    abstract protected BaseService<T, ID> getEntityService();
    protected boolean isRequestHeaderTable(){
        HttpServletRequest request = getContext().getRequest();
        String isTable = request.getHeader("table");
        return isTable != null && isTable.equals("true");
    }
    protected Page<T> findByPage(){
        return getEntityService().findPage(resolverSearchable());
    }

    protected Searchable resolverSearchable(){
        return (Searchable) new SearchableArgumentResolver().resolveArgument(this, getContext());
    }
}

package k0n9.common.web;

import k0n9.common.entity.Persistable;
import k0n9.common.service.BaseService;

import java.io.Serializable;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class CRUDActionBean<T extends Persistable, ID extends Serializable> extends BaseActionBean {
    abstract protected BaseService<T, ID> getEntityService();
}

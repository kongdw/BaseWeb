package k0n9.module.sys.web;

import com.google.inject.Inject;
import k0n9.comm.service.BaseService;
import k0n9.comm.web.BaseActionBean;
import k0n9.module.sys.entity.Resource;
import k0n9.module.sys.service.ResourceService;

/**
 * @author David Kong
 * @version 1.0
 */
public class ResourceActionBean extends BaseActionBean<Resource,Long> {

    @Inject
    private ResourceService resourceService;

    @Override
    protected BaseService<Resource, Long> getEntityService() {
        return resourceService;
    }

}
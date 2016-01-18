package k0n9.module.sys.service;

import com.google.inject.Inject;
import k0n9.comm.dao.BaseMapper;
import k0n9.comm.service.BaseService;
import k0n9.module.sys.dao.ResourceMapper;
import k0n9.module.sys.entity.Resource;

/**
 * @author David Kong
 * @version 1.0
 */
public class ResourceService extends BaseService<Resource,Long> {

    @Inject
    private ResourceMapper resourceMapper;

    @Override
    protected BaseMapper<Resource, Long> getEntityMapper() {
        return resourceMapper;
    }

}

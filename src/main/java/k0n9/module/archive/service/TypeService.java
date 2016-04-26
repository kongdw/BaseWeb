package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.TypeMapper;
import k0n9.module.archive.entity.Type;

/**
 * @author David Kong
 * @version 1.0
 */
public class TypeService extends BaseService<Type,Long> {

    @Inject
    private TypeMapper typeMapper;

    @Override
    protected BaseMapper<Type, Long> getEntityMapper() {
        return typeMapper;
    }
}

package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.UrgentLevelMapper;
import k0n9.module.archive.entity.UrgentLevel;

/**
 * @author David Kong
 * @version 1.0
 */
public class UrgentLevelService extends BaseService<UrgentLevel,Long> {

    @Inject
    private UrgentLevelMapper urgentLevelMapper;

    @Override
    protected BaseMapper<UrgentLevel, Long> getEntityMapper() {
        return urgentLevelMapper;
    }
}

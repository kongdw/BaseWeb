package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.PrivacyLevelMapper;
import k0n9.module.archive.entity.PrivacyLevel;

/**
 * @author David Kong
 * @version 1.0
 */
public class PrivacyLevelService extends BaseService<PrivacyLevel,Long> {

    @Inject
    private PrivacyLevelMapper privacyLevelMapper;

    @Override
    protected BaseMapper<PrivacyLevel, Long> getEntityMapper() {
        return privacyLevelMapper;
    }
}

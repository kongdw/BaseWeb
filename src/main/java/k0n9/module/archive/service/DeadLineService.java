package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.DeadLineMapper;
import k0n9.module.archive.entity.DeadLine;

/**
 * @author David Kong
 * @version 1.0
 */
public class DeadLineService extends BaseService<DeadLine,Long> {

    @Inject
    private DeadLineMapper deadLineMapper;

    @Override
    protected BaseMapper<DeadLine, Long> getEntityMapper() {
        return deadLineMapper;
    }
}

package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.ArchiveMapper;
import k0n9.module.archive.entity.Archive;

/**
 * @author David Kong
 * @version 1.0
 */
public class ArchiveService extends BaseService<Archive,Long>{

    @Inject
    private ArchiveMapper archiveMapper;

    @Override
    protected BaseMapper<Archive, Long> getEntityMapper() {
        return archiveMapper;
    }
}

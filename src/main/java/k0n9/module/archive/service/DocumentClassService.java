package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.DocumentClassMapper;
import k0n9.module.archive.entity.DocumentClass;

/**
 * @author David Kong
 * @version 1.0
 */
public class DocumentClassService extends BaseService<DocumentClass,Long> {

    @Inject
    private DocumentClassMapper documentClassMapper;

    @Override
    protected BaseMapper<DocumentClass, Long> getEntityMapper() {
        return documentClassMapper;
    }
}

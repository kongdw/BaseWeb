package k0n9.module.archive.web;

import com.google.inject.Inject;
import k0n9.common.service.BaseService;
import k0n9.common.web.CRUDActionBean;
import k0n9.module.archive.entity.Archive;
import k0n9.module.archive.service.ArchiveService;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

/**
 * @author David Kong
 * @version 1.0
 */
public class ArchiveBaseActionBean extends CRUDActionBean<Archive, Long> {

    @Inject
    protected ArchiveService archiveService;

    @Override
    protected BaseService<Archive, Long> getEntityService() {
        return archiveService;
    }

    @Validate(on = {"delete", "view"}, required = true)
    private Long archiveId;

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    @ValidateNestedProperties({
            @Validate(field = "title",on = {"save"}, required = true)
    })
    private Archive archive;

    public Archive getArchive() {
        if (archiveId != null) {
            return getEntityService().fetch(archiveId);
        }
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}

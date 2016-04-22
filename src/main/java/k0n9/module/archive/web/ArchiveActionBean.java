package k0n9.module.archive.web;

import com.google.inject.Inject;
import k0n9.common.service.BaseService;
import k0n9.common.web.BaseActionBean;
import k0n9.module.archive.entity.Archive;
import k0n9.module.archive.service.ArchiveService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/archive/browse")
public class ArchiveActionBean extends BaseActionBean<Archive,Long> {

    @Inject
    private ArchiveService archiveService;

    @Override
    protected BaseService<Archive, Long> getEntityService() {
        return archiveService;
    }

    @DefaultHandler
    public Resolution index(){
        return  new ForwardResolution("/WEB-INF/jsp/admin/archive/browse.jsp");
    }

    public Resolution list(){
        return null;
    }
}

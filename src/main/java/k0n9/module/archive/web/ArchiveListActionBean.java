package k0n9.module.archive.web;

import k0n9.module.archive.entity.Archive;
import net.sourceforge.stripes.action.*;

import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/archive")
public class ArchiveListActionBean extends ArchiveBaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/admin/archive/list.jsp";

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }

    public List<Archive> getArchives() {
        return getEntityService().findByPage(new Archive());
    }

    public Resolution delete() {
        Archive deleted = getEntityService().fetch(getArchiveId());
        getEntityService().delete(getArchiveId());
        getContext().getMessages().add(new SimpleMessage("Deleted {0}", deleted));
        return new RedirectResolution(getClass());
    }

}

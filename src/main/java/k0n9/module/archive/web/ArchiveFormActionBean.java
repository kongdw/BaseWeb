package k0n9.module.archive.web;

import k0n9.module.archive.entity.Archive;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/archive/browse/save")
public class ArchiveFormActionBean extends ArchiveBaseActionBean {

    private static final String FORM = "/WEB-INF/jsp/admin/archive/editForm.jsp";

    @DefaultHandler
    public Resolution form() {
        return new ForwardResolution(FORM);
    }

    public Resolution save() {
        Archive archive = getArchive();
        getEntityService().insert(archive);
        getContext().getMessages().add(new SimpleMessage("{0} has been saved", archive));
        return new RedirectResolution(ArchiveListActionBean.class);
    }

    @DontValidate
    public Resolution cancel() {
        getContext().getMessages().add(
                new SimpleMessage("Action cancelled."));
        return new RedirectResolution(ArchiveListActionBean.class);
    }
}
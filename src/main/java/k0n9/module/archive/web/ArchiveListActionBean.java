package k0n9.module.archive.web;

import com.google.inject.Inject;
import k0n9.module.archive.entity.Archive;
import k0n9.module.archive.entity.Category;
import k0n9.module.archive.entity.DeadLine;
import k0n9.module.archive.entity.DocumentClass;
import k0n9.module.archive.entity.PrivacyLevel;
import k0n9.module.archive.entity.Type;
import k0n9.module.archive.entity.UrgentLevel;
import k0n9.module.archive.service.CategoryService;
import k0n9.module.archive.service.DeadLineService;
import k0n9.module.archive.service.DocumentClassService;
import k0n9.module.archive.service.PrivacyLevelService;
import k0n9.module.archive.service.TypeService;
import k0n9.module.archive.service.UrgentLevelService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;

import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/archive/{$event}/{archiveId}")
//@RolesAllowed("Administrator")
public class ArchiveListActionBean extends ArchiveBaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/admin/archive/list.jsp";
    private static final String FORM = "/WEB-INF/jsp/admin/archive/editForm.jsp";
    private static final String TABLE = "/WEB-INF/jsp/admin/archive/listTable.jsp";

    @Inject
    private TypeService typeService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private DeadLineService deadLineService;
    @Inject
    private DocumentClassService documentClassService;
    @Inject
    private PrivacyLevelService privacyLevelService;
    @Inject
    private UrgentLevelService urgentLevelService;

    /**
     * 显示列表
     *
     * @return
     */
    @DefaultHandler
    public Resolution list() {
        if (isRequestHeaderTable()) {
            return new ForwardResolution(TABLE);
        } else {
            return new ForwardResolution(LIST);
        }
    }
    public Resolution form() {
        return new ForwardResolution(FORM);
    }

    public Resolution update() {
        return new ForwardResolution(FORM);
    }

    public Resolution delete() {
        Archive deleted = getEntityService().fetch(getArchiveId());
        getEntityService().delete(getArchiveId());
        getContext().getMessages().add(new SimpleMessage("标题为《{0}》的档案被删除!", deleted.getTitle()));
        return new RedirectResolution(getClass());
    }

    public Resolution save() {
        Archive archive = getArchive();
        getEntityService().save(archive);
        getContext().getMessages().add(new SimpleMessage("标题为《{0}》的档案已保存!", archive.getTitle()));
        return new RedirectResolution(ArchiveListActionBean.class);
    }

    @DontValidate
    public Resolution cancel() {
        getContext().getMessages().add(
                new SimpleMessage("Action cancelled."));
        return new RedirectResolution(ArchiveListActionBean.class);
    }

    public List<Archive> getArchives() {
        return getEntityService().findByList(getArchive());
    }

    public List<Type> getType() {
        return typeService.findByList(new Type());
    }

    public List<Category> getCategory() {
        return categoryService.findByList(new Category());
    }

    public List<DeadLine> getDeadLine() {
        return deadLineService.findByList(new DeadLine());
    }

    public List<DocumentClass> getDocClass() {
        return documentClassService.findByList(new DocumentClass());
    }

    public List<PrivacyLevel> getPrivacyLevel() {
        return privacyLevelService.findByList(new PrivacyLevel());
    }

    public List<UrgentLevel> getUrgentLevel() {
        return urgentLevelService.findByList(new UrgentLevel());
    }


}

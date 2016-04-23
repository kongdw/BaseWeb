package k0n9.module.sys.web;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import k0n9.common.entity.search.Searchable;
import k0n9.common.web.bind.PageableDefaults;
import k0n9.common.web.bind.SearchableDefaults;
import k0n9.module.sys.entity.Menu;
import k0n9.module.sys.service.ResourceService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;

import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/main")
public class MainActionBean implements ActionBean {

    private static final String MAIN = "/WEB-INF/index.jsp";

    private ActionBeanContext context;

    @Inject
    private ResourceService resourceService;

    @Validate(on = {"main"}, required = true, ignore = true)
    private Searchable searchable = Searchable.newSearchable();

    @Override
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    private List<Menu> menus = Lists.newArrayList();

    @DefaultHandler
    @PageableDefaults(value = 100, pageNumber = 2, sort = {"a=desc", "b=desc"})
    @SearchableDefaults(value = {"age_lt=124", "name_like=abc", "id_in=1,2,3,4"}, merge = true)
    public Resolution main() {
         setMenus(resourceService.findMenus());
        return new ForwardResolution(MAIN);
    }

    public Searchable getSearchable() {
        return searchable;
    }

    public void setSearchable(Searchable searchable) {
        this.searchable = searchable;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}

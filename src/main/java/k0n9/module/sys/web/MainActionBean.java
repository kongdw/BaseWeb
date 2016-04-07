package k0n9.module.sys.web;

import k0n9.common.web.bind.PageableDefaults;
import k0n9.common.web.bind.SearchableDefaults;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/main")
public class MainActionBean implements ActionBean{

    private ActionBeanContext context;

    @Override
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    @DefaultHandler
    @PageableDefaults(value = 100,pageNumber = 2,sort ={"a=desc","b=desc"})
    @SearchableDefaults(value = {"age_lt=123", "name_like=abc", "id_in=1,2,3,4"},merge = true)
    public Resolution main() {
        return new ForwardResolution("/main.jsp");
    }
}

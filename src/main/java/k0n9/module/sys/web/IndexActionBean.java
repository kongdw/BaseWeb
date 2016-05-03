package k0n9.module.sys.web;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import k0n9.common.web.BaseActionBean;
import k0n9.module.sys.entity.Menu;
import k0n9.module.sys.service.ResourceService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/index")
public class IndexActionBean extends BaseActionBean {

    private static final String INDEX = "/WEB-INF/jsp/admin/index/index.jsp";
    private static final String WELCOME = "/WEB-INF/jsp/admin/index/welcome.jsp";

    @Inject
    private ResourceService resourceService;

    private List<Menu> menus = Lists.newArrayList();

    @DefaultHandler
    public Resolution index(){
        return new ForwardResolution(INDEX);
    }

    @HandlesEvent("welcome")
    public Resolution welcome(){
        return new ForwardResolution(WELCOME);
    }

    public List<Menu> getMenus() {
        if(CollectionUtils.isEmpty(menus)){
            menus = resourceService.findMenus();
        }
        return menus;
    }

}

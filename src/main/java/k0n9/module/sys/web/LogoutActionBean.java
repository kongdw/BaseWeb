package k0n9.module.sys.web;

import k0n9.common.web.BaseActionBean;
import k0n9.common.plugins.stripes.extensions.BaseActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/logout")
public class LogoutActionBean extends BaseActionBean {
    @DefaultHandler
    public Resolution logout() {
        ((BaseActionBeanContext) getContext()).logout();
        return new RedirectResolution(LoginActionBean.class);
    }
}

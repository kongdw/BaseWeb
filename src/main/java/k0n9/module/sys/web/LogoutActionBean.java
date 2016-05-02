package k0n9.module.sys.web;

import k0n9.common.web.BaseActionBean;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 * @author David Kong
 * @version 1.0
 */
public class LogoutActionBean extends BaseActionBean {
    public Resolution logout() {
        getContext().logout();
        return new RedirectResolution(LoginActionBean.class);
    }
}

package k0n9.common.plugins.stripes.security;

import k0n9.common.web.BaseActionBean;
import k0n9.module.sys.entity.Role;
import k0n9.module.sys.entity.User;
import k0n9.module.sys.web.LoginActionBean;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author David Kong
 * @version 1.0
 */
public class MySecurityManager  extends InstanceBasedSecurityManager implements SecurityHandler {
    @Override
    protected Boolean isUserAuthenticated(ActionBean bean, Method handler) {
        return getUser(bean) != null;
    }

    @Override
    protected Boolean hasRoleName(ActionBean bean, Method handler, String role) {
        User user = getUser(bean);
        if (user != null) {
            Collection<Role> roles = user.getRoles();
            return roles != null && roles.contains(new Role(role));
        }
        return false;
    }

    public Resolution handleAccessDenied(ActionBean bean,Method handler) {
        if (!isUserAuthenticated(bean, handler)) {
            return new RedirectResolution(LoginActionBean.class);
        }
        return new ErrorResolution(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private User getUser(ActionBean bean) {
        return ((BaseActionBean) bean).getContext().getUser();
    }

}


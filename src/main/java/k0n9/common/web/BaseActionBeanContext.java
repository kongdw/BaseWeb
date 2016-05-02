package k0n9.common.web;

import k0n9.module.sys.entity.User;
import net.sourceforge.stripes.action.ActionBeanContext;

import javax.servlet.http.HttpSession;

/**
 * @author David Kong
 * @version 1.0
 */
public class BaseActionBeanContext extends ActionBeanContext {
    public User getUser() {
        return (User) getRequest().getSession().getAttribute("user");
    }

    public void setUser(User currentUser) {
        getRequest().getSession().setAttribute("user", currentUser);
    }

    public void logout() {
        setUser(null);
        HttpSession session = getRequest().getSession(); if (session != null) {
            session.invalidate();
        }
    }
}

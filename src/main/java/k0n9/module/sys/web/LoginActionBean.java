package k0n9.module.sys.web;

import com.google.inject.Inject;
import k0n9.module.sys.service.AuthService;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/login")
public class LoginActionBean implements ActionBean {

    private static final String LOGIN_URL = "/index.jsp";

    private ActionBeanContext context;

    @Inject
    private AuthService authService;

    @Override
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    @Validate(on = {"login"}, required = true, maxlength = 20, minlength = 5, mask = "[0-9a-zA-Z]+")
    private String username;
    @Validate(on = {"login"}, required = true, maxlength = 20, minlength = 5)
    private String password;
    private String targetUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    @DefaultHandler
    public Resolution login() {
        if (authService.login(username, password)) {
            if (this.targetUrl != null) {
                return new RedirectResolution(this.targetUrl);
            }
            return new RedirectResolution("/main");
        } else {
            ValidationError error = new SimpleError("用户名或密码不正确.");
            getContext().getValidationErrors().addGlobalError(error);
            return getContext().getSourcePageResolution();
        }
    }

}

package k0n9.module.sys.web;

import com.google.inject.Inject;
import k0n9.common.web.BaseActionBean;
import k0n9.module.sys.service.AuthService;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/login")
public class LoginActionBean extends BaseActionBean {

    private static final String LOGIN_FORM = "/WEB-INF/jsp/front/login.jsp";

    @Inject
    private AuthService authService;

    @Validate(on = {"login"}, required = true, maxlength = 20, minlength = 5, mask = "[0-9a-zA-Z]+")
    private String username;
    @Validate(on = {"login"}, required = true, maxlength = 20, minlength = 5)
    private String password;
    private String targetUrl;

    @DefaultHandler
    @DontValidate
    public Resolution view(){
        return new ForwardResolution(LOGIN_FORM);
    }

    public Resolution login() {
        if (authService.login(username, password)) {
            if (this.targetUrl != null) {
                return new RedirectResolution(this.targetUrl);
            }
            return new RedirectResolution(IndexActionBean.class);
        } else {
            ValidationError error = new LocalizableError("usernameOrPasswordInvalided");
            getContext().getValidationErrors().addGlobalError(error);
            return getContext().getSourcePageResolution();
        }
    }


    public void setUsername(String username) {
        this.username = username;
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

}

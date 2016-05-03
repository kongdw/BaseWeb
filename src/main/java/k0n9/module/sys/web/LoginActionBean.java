package k0n9.module.sys.web;

import com.google.inject.Inject;
import k0n9.common.plugins.stripes.PasswordTypeConverter;
import k0n9.common.web.BaseActionBean;
import k0n9.module.sys.entity.User;
import k0n9.module.sys.service.AuthService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/login")
public class LoginActionBean extends BaseActionBean {

    private static final String LOGIN_FORM = "/WEB-INF/jsp/front/login.jsp";

    @Inject
    private AuthService authService;

    private User user;

    @Validate(required = true, maxlength = 20, minlength = 5, mask = "[0-9a-zA-Z]+")
    private String username;

    @Validate(required = true, maxlength = 20, minlength = 5,converter = PasswordTypeConverter.class)
    private String password;
    private String targetUrl;

    @DefaultHandler
    @DontValidate
    public Resolution view(){
        return new ForwardResolution(LOGIN_FORM);
    }

    public Resolution login() {
        getContext().setUser(user);
        if (this.targetUrl != null) {
            return new RedirectResolution(this.targetUrl);
        }
        return new RedirectResolution(IndexActionBean.class);
    }

    @ValidationMethod
    public void validateUser(ValidationErrors errors) {
        user = authService.findByUsername(username);
        if (user == null) {
            errors.add("username", new LocalizableError("usernameNotFound"));
        }
       else if (!user.getPassword().equals(password)) {
            errors.add("password", new LocalizableError("passwordIncorrect"));
        }
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

}

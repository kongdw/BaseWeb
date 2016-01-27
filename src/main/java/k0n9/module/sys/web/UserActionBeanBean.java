package k0n9.module.sys.web;

import com.google.inject.Inject;
import k0n9.comm.service.BaseService;
import k0n9.comm.stripes.JsonResolution;
import k0n9.comm.web.BaseActionBean;
import k0n9.module.sys.entity.User;
import k0n9.module.sys.service.UserService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/user")
public class UserActionBeanBean extends BaseActionBean<User,Long> {

    private static final String LIST_FORWARD = "/WEB-INF/jsp/admin/user/userList.jsp";
    private static final String FORM_FORWARD = "/WEB-INF/jsp/admin/user/form.jsp";

    private UserService userService;

    private List<User> users;

    protected BaseService<User, Long> getEntityService() {
        return userService;
    }

    @ValidateNestedProperties({
            @Validate(on = "save", field = "username", required = true),
            @Validate(on = "save", field = "password", required = true)
    })
    private User user;


    @Inject
    public UserActionBeanBean(UserService userService){
        this.userService = userService;
    }

    @DefaultHandler
    public Resolution list() {
        users = userService.findList(super.buildSearchable());
        return new ForwardResolution(LIST_FORWARD);
    }


    public Resolution ajaxList(){
        users = userService.findList(super.buildSearchable());
        return new JsonResolution(users);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

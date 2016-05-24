package k0n9.module.sys.web;

import com.google.inject.Inject;
import k0n9.common.entity.search.domain.Page;
import k0n9.common.service.BaseService;
import k0n9.common.web.CRUDActionBean;
import k0n9.module.sys.entity.User;
import k0n9.module.sys.service.UserService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/user")
public class UserActionBean extends CRUDActionBean<User,Long> {

    private static final String LIST_FORWARD = "/WEB-INF/jsp/admin/user/userList.jsp";
    private static final String FORM_FORWARD = "/WEB-INF/jsp/admin/user/editForm.jsp";

    private UserService userService;

    private Page<User> users;

    @Override
    protected BaseService<User, Long> getEntityService() {
        return userService;
    }

    @ValidateNestedProperties({
            @Validate(on = "save", field = "username", required = true),
            @Validate(on = "save", field = "password", required = true)
    })
    private User user;


    @Inject
    public UserActionBean(UserService userService){
        this.userService = userService;
    }

    @DefaultHandler
    public Resolution list() {
        users = findByPage();
        return new ForwardResolution(LIST_FORWARD);
    }

    public Page<User> getUsers() {
        return users;
    }

    public void setUsers(Page<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

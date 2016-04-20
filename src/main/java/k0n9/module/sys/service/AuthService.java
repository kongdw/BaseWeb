package k0n9.module.sys.service;

import com.google.inject.Inject;
import k0n9.common.utils.security.Md5Utils;
import k0n9.module.sys.entity.User;

/**
 * @author David Kong
 * @version 1.0
 */
public class AuthService {

    @Inject
    private UserService userService;

    public boolean login(String username, String password) {
        User user = userService.fetchByUsername(username);
        return user != null && Md5Utils.hash(password+user.getSalt()).equals(user.getPassword());
    }

}

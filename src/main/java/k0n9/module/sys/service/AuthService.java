package k0n9.module.sys.service;

import com.google.inject.Inject;

/**
 * @author David Kong
 * @version 1.0
 */
public class AuthService  {

    @Inject
    private UserService userService;

    public boolean login(String username,String password){
        return true;
    }

}

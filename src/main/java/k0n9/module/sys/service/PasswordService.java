package k0n9.module.sys.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import k0n9.comm.utils.security.Md5Utils;
import k0n9.module.sys.entity.User;

/**
 * @author David Kong
 * @version 1.0
 */
public class PasswordService {

    // 登录错误次数
    @Inject(optional = true)
    @Named("maxRetryCount")
    private int maxRetryCount = 10;

    public void validate(User user, String password) {
        String username = user.getUsername();
        int retryCount = 0;

        if(!matches(user,password)){
        }
    }

    public boolean matches(User user,String newPassword){
        return user.getPassword().equals(encryptPassword(user.getUsername(),newPassword,user.getSalt()));
    }

    public String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }
}

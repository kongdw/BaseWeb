package k0n9.module.sys.service;

import com.google.inject.Inject;
import k0n9.comm.dao.BaseMapper;
import k0n9.comm.service.BaseService;
import k0n9.module.sys.dao.UserMapper;
import k0n9.module.sys.entity.User;

/**
 * @author David Kong
 * @version 1.0
 */
public class UserService extends BaseService<User,Long> {

    private UserMapper userMapper;

    @Inject
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    protected BaseMapper<User, Long> getEntityMapper() {
        return userMapper;
    }

}

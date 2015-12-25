package k0n9.module.sys.service;

import com.google.inject.Inject;
import k0n9.module.sys.dao.UserMapper;
import k0n9.module.sys.entity.User;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
public class UserService {

    private UserMapper userMapper;

    @Inject
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    public int update(User user) {
        return userMapper.update(user);
    }

    public User fetch(Long id) {
        return userMapper.fetch(id);
    }

    public List<User> findByList(User user) {
        return userMapper.findByList(user);
    }
}

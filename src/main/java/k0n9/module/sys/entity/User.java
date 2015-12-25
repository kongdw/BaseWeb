package k0n9.module.sys.entity;

import k0n9.comm.entity.BaseEntity;
import k0n9.comm.stripes.JsonIgnore;

/**
 * @author David Kong
 * @version 1.0
 */
public class User extends BaseEntity<Long> {

    private static final long serialVersionUID = -3388132446560598779L;
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String qq;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

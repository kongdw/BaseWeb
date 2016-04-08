package k0n9.module.sys.entity;

import k0n9.common.annotation.TableAlias;
import k0n9.common.entity.BaseEntity;
import k0n9.common.plugins.stripes.action.JsonIgnore;

import java.util.Date;

/**
 * 用户
 * @author David Kong
 * @version 1.0
 */
@TableAlias("user")
public class User extends BaseEntity<Long> {

    private static final long serialVersionUID = -3388132446560598779L;
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private String salt;
    private Date createDate;
    private String status;
    private Boolean deleted;
    private Boolean isAdmin;

    @TableAlias("role")
    private Role role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package k0n9.module.sys.entity;

import k0n9.common.entity.BaseEntity;
import k0n9.common.plugins.stripes.action.JsonIgnore;

/**
 * 角色
 * @author David Kong
 * @version 1.0
 * @since 1.0
 */
public class Role extends BaseEntity<Long>{

    private static final long serialVersionUID = 459946315221806103L;
    private Long id;
    private String name;
    private String role;
    private String description;
    @JsonIgnore
    private boolean isShow;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }
}

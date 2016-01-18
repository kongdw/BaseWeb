package k0n9.module.sys.entity;

import k0n9.comm.entity.BaseEntity;
import k0n9.comm.entity.plugin.Tree;

/**
 * 资源实体
 *
 * @author David Kong
 * @version 1.0
 */
public class Resource extends BaseEntity<Long> implements Tree<Long> {

    private static final long serialVersionUID = 3054589666655196403L;

    private Long id;
    private Long parentId;
    /**
     * 标题
     */
    private String name;
    /**
     * 资源标识符 用于权限匹配的 如sys:resource
     */
    private String identity;

    /**
     * 点击后前往的地址
     * 菜单才有
     */
    private String url;

    private String icon;

    private String parentIds;

    private Integer weight;

    private Boolean hasChildren;

    private Boolean isShow = Boolean.FALSE;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    @Override
    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public boolean isLeaf() {
        if (isRoot()) {
            return false;
        }
        if (isHasChildren()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isRoot() {
        if (getParentId() != null && getParentId() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getParentIds() {
        return parentIds;
    }

    @Override
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public String getSeparator() {
        return ",";
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

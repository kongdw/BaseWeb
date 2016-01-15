package k0n9.comm.entity;

import k0n9.comm.entity.plugin.Tree;

import java.io.Serializable;

/**
 * 树形基础类
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class TreeEntity<ID extends Serializable> extends BaseEntity<ID> implements Tree<ID> {
    private static final long serialVersionUID = 996510344425903783L;

    private static final String DEFAULT_PARENTIDS_SEPARATOR = ",";
    private static final int DEFAULT_ROOT_KEY = 0;

    private String name;
    private String icon;
    private String parentIds;
    private Integer weight;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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
        return DEFAULT_PARENTIDS_SEPARATOR;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean isRoot() {
        return getParentId() != null;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isHasChildren() {
        return false;
    }
}

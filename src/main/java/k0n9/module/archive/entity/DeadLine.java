package k0n9.module.archive.entity;

import k0n9.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author David Kong
 * @version 1.0
 */
@Entity
@Table(name = "dl")
public class DeadLine extends BaseEntity<Long> {
    private static final long serialVersionUID = -3288949373112976522L;

    private Long id;
    private String name;
    private Integer weight;
    private Boolean isShow = Boolean.FALSE;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

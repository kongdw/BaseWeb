package k0n9.module.sys.entity;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体类
 *
 * @author David Kong
 * @version 1.0
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 8442291931896529187L;
    private Long id;
    private String name;
    private String url;
    private String icon;
    private List<Menu> children;

    public Menu(Long id, String name, String icon, String url) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChildren() {
        if (children == null) {
            children = Lists.newArrayList();
        }
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public boolean isHasChildren() {
        return !getChildren().isEmpty();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

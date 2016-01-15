package k0n9.comm.entity.plugin;

import java.io.Serializable;

/**
 * 树形接口
 *
 * @author David Kong
 *         date : 2015/11/9
 * @version 1.0
 */
public interface Tree<ID extends Serializable> {

    void setName(String name);

    String getName();

    /**
     * 显示的图标
     *
     * @return 图标icon
     */
    String getIcon();

    void setIcon(String icon);

    /**
     * 父路径
     *
     * @return 父节点ID
     */
    ID getParentId();

    void setParentId(ID parentId);

    /**
     * 所有父路径
     *
     * @return 如1, 2, 3,
     */
    String getParentIds();

    void setParentIds(String parentIds);

    /**
     * 获取 parentIds 之间的分隔符
     *
     * @return 默认","分割
     */
    String getSeparator();

    /**
     * 权重 用于排序 越小越排在前边
     *
     * @return 权重值
     */
    Integer getWeight();

    void setWeight(Integer weight);

    /**
     * 是否是根节点
     *
     * @return true:是根节点 false:不是根节点
     */
    boolean isRoot();

    /**
     * 是否是叶子节点
     *
     * @return true:叶子节点 false:不是叶子节点
     */
    boolean isLeaf();

    /**
     * 是否有孩子节点
     *
     * @return true:有子节点 false:没有子节点
     */
    boolean isHasChildren();

}

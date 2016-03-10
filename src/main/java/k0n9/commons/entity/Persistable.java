package k0n9.commons.entity;

import java.io.Serializable;

/**
 * 实体类接口
 * @author David Kong
 * @version 1.0
 */
public interface Persistable<ID extends Serializable> extends Serializable {

    /**
     * 获取业务对象唯一键
     * @return 返回 ID 泛型值
     */
    ID getId();

    /**
     * 判断业务对象是否为新对象
     * @return true 新对象 false 非新对象
     */
    boolean isNew();
}

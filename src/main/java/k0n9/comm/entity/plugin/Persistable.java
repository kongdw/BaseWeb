package k0n9.comm.entity.plugin;

import java.io.Serializable;

/**
 *
 * @author David Kong
 * @version 1.0
 */
public interface Persistable<ID extends Serializable> extends Serializable {

    /**
     * 获取业务对象唯一键
     * @return
     */
    ID getId();

    /**
     * 判断业务对象是否为新对象
     * @return
     */
    boolean isNew();
}

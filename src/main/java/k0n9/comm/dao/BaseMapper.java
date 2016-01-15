package k0n9.comm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 数据访问接口
 * @author David Kong
 * @version 1.0
 */
public interface BaseMapper<T,ID extends Serializable> {

    /**
     * 插入数据
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 修改数据
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int delete(ID id);

    int deleteByIds(ID... ids);

    /**
     * 获取一条数据
     * @param id
     * @return
     */
    T fetch(ID id);

    /**
     * 分页查询
     * @param searchMap 查询条件
     * @return
     */
    List<T> findPage(T entity);

    /**
     * 查询所有数据列表
     * @param searchMap 查询条件
     * @return
     */
    List<T> findList(T entity);

    /**
     * 查询ID数组
     * @param ids
     * @return
     */
    List<T> findByIds(ID[] ids);
}

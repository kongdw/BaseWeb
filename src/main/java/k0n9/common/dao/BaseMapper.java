package k0n9.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 数据访问通用接口
 *
 * @author David Kong
 * @version 1.0
 */
public interface BaseMapper<T, ID extends Serializable> {

    /**
     * 插入数据
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(T entity);

    /**
     * 修改数据
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(T entity);

    /**
     * 选择修改
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int updateSelective(T entity);

    /**
     * 删除
     *
     * @param id 实体唯一标识
     * @return 影响行数
     */
    int delete(ID id);

    /**
     * 批量删除
     *
     * @param ids 实体唯一标识集合
     * @return 影响行数
     */
    int deleteByIds(ID[] ids);

    /**
     * 获取一条数据
     *
     * @param id 实体唯一标识
     * @return 实体对象
     */
    T fetch(ID id);

    /**
     * 查询所有数据列表
     *
     * @param entity 查询条件
     * @return 满足查询条件的集合
     */
    List<T> findPage(T entity);

    /**
     * 查询所有数据列表
     *
     * @param entity 查询条件
     * @return 满足查询条件的集合
     */
    List<T> findList(T entity);

    /**
     * 查询ID数组
     *
     * @param ids
     * @return
     */
    List<T> findByIds(ID[] ids);
}

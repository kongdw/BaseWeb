package k0n9.common.service;

import k0n9.common.dao.BaseMapper;
import k0n9.common.entity.Persistable;
import k0n9.common.entity.search.domain.Page;
import k0n9.common.entity.search.domain.PageImpl;
import k0n9.common.plugins.mybatis.PaginationInterceptor;
import org.mybatis.guice.transactional.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseService<T extends Persistable, ID extends Serializable> {

    /**
     * 子类指定泛型对应的实体Mapper接口对象
     */
    abstract protected BaseMapper<T, ID> getEntityMapper();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    @Transactional
    public int save(T entity) {
        if(entity.isNew()){
            return getEntityMapper().insert(entity);
        }else {
            return getEntityMapper().update(entity);
        }
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Transactional
    public int delete(ID id) {
        return getEntityMapper().delete(id);
    }

    @Transactional
    public int deleteByIds(ID[] ids) {
        return getEntityMapper().deleteByIds(ids);
    }

    /**
     * 获取一条数据
     *
     * @param id
     * @return
     */
    public T fetch(ID id) {
        return getEntityMapper().fetch(id);
    }

    /**
     * 分页查询数据
     *
     * @param entity
     * @return
     */
    public Page<T> findByPage(T entity) {
        int count = PaginationInterceptor.getPaginationTotal();
        return new PageImpl<T>(getEntityMapper().findPage(entity));
    }


    public List<T> findByList(T entity){
        return getEntityMapper().findList(entity);
    }
    /**
     * 查询ID数组
     *
     * @param ids
     * @return
     */
    public List<T> findByIds(ID[] ids) {
        return getEntityMapper().findByIds(ids);
    }
}

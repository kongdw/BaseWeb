package k0n9.common.service;

import k0n9.common.dao.BaseMapper;
import k0n9.common.entity.Persistable;
import k0n9.common.entity.search.Searchable;
import k0n9.common.entity.search.domain.Page;
import k0n9.common.entity.search.domain.PageImpl;
import org.mybatis.guice.transactional.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseService<T extends Persistable, ID extends Serializable> {

    protected final Class<T> entityClass;

    /**
     * 子类指定泛型对应的实体Mapper接口对象
     */
    abstract protected BaseMapper<T, ID> getEntityMapper();

    protected BaseService() {
        this.entityClass = findParameterizedType(getClass(), 0);
    }

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    @Transactional
    public int save(T entity) {
        if (entity.isNew()) {
            return getEntityMapper().insert(entity);
        } else {
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
     * @param searchable
     * @return
     */
    public Page<T> findPage(Searchable searchable) {
        if(!searchable.isConverted()){
            searchable.convert(entityClass);
        }
        Long total = getEntityMapper().findCount(searchable);
        total = total == null ? 0l : total;
        return new PageImpl<T>(getEntityMapper().findPage(searchable),
                searchable.getPage(),
                total);
    }

    public List<T> findList(T entity) {
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

    public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
        Type parameterizedType = clazz.getGenericSuperclass();
        //CGLUB subclass target object(泛型在父类上)
        if (!(parameterizedType instanceof ParameterizedType)) {
            parameterizedType = clazz.getSuperclass().getGenericSuperclass();
        }
        if (!(parameterizedType instanceof ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) parameterizedType).getActualTypeArguments();
        if (actualTypeArguments == null || actualTypeArguments.length == 0) {
            return null;
        }
        return (Class<T>) actualTypeArguments[0];
    }
}

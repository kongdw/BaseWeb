package k0n9.module.sys.dao;

import k0n9.common.dao.BaseMapper;
import k0n9.module.sys.entity.Resource;

import java.util.List;

/**
 * 资源数据访问层
 * @author David Kong
 * @version 1.0
 */
public interface ResourceMapper extends BaseMapper<Resource,Long> {

    public List<Resource> findMenus();
}

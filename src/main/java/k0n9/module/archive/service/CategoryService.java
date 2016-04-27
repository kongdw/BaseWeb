package k0n9.module.archive.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.service.BaseService;
import k0n9.module.archive.dao.CategoryMapper;
import k0n9.module.archive.entity.Category;

/**
 * @author David Kong
 * @version 1.0
 */
public class CategoryService extends BaseService<Category,Long> {

    @Inject
    private CategoryMapper categoryMapper;

    @Override
    protected BaseMapper<Category, Long> getEntityMapper() {
        return categoryMapper;
    }
}

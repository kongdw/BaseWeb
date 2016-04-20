package k0n9.module.sys.service;

import com.google.inject.Inject;
import k0n9.common.dao.BaseMapper;
import k0n9.common.plugins.mybatis.util.StringUtils;
import k0n9.common.service.BaseService;
import k0n9.module.sys.dao.ResourceMapper;
import k0n9.module.sys.entity.Menu;
import k0n9.module.sys.entity.Resource;

import java.util.Collections;
import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
public class ResourceService extends BaseService<Resource,Long> {

    @Inject
    private ResourceMapper resourceMapper;

    @Override
    protected BaseMapper<Resource, Long> getEntityMapper() {
        return resourceMapper;
    }


    public List<Menu> findMenus() {

        List<Resource> resources = resourceMapper.findMenus();

        return convertToMenus(resources);
    }

    @SuppressWarnings("unchecked")
    public static List<Menu> convertToMenus(List<Resource> resources) {

        if (resources.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        Menu root = convertToMenu(resources.remove(resources.size() - 1));

        recursiveMenu(root, resources);
        List<Menu> menus = root.getChildren();
        removeNoLeafMenu(menus);

        return menus;
    }

    private static void removeNoLeafMenu(List<Menu> menus) {
        if (menus.size() == 0) {
            return;
        }
        for (int i = menus.size() - 1; i >= 0; i--) {
            Menu m = menus.get(i);
            removeNoLeafMenu(m.getChildren());
            if (!m.isHasChildren() && StringUtils.isEmpty(m.getUrl())) {
                menus.remove(i);
            }
        }
    }

    private static void recursiveMenu(Menu menu, List<Resource> resources) {
        for (int i = resources.size() - 1; i >= 0; i--) {
            Resource resource = resources.get(i);
            if (resource.getParentId().equals(menu.getId())) {
                menu.getChildren().add(convertToMenu(resource));
                resources.remove(i);
            }
        }

        for (Menu subMenu : menu.getChildren()) {
            recursiveMenu(subMenu, resources);
        }
    }

    private static Menu convertToMenu(Resource resource) {
        return new Menu(resource.getId(), resource.getName(), resource.getIcon(), resource.getUrl());
    }

}

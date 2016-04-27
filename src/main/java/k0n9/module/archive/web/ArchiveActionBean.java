package k0n9.module.archive.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.inject.Inject;
import k0n9.common.plugins.mybatis.model.Page;
import k0n9.common.plugins.stripes.action.JsonResolution;
import k0n9.common.service.BaseService;
import k0n9.common.web.BaseActionBean;
import k0n9.module.archive.entity.Archive;
import k0n9.module.archive.entity.Type;
import k0n9.module.archive.service.ArchiveService;
import k0n9.module.archive.service.TypeService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import java.util.List;
import java.util.Map;

/**
 * @author David Kong
 * @version 1.0
 */
@UrlBinding("/archive/browse")
public class ArchiveActionBean extends BaseActionBean<Archive, Long> {

    private static final String LIST = "/WEB-INF/jsp/admin/archive/list.jsp";
    private static final String FORM = "/WEB-INF/jsp/admin/archive/form.jsp";

    private List<Type> typeList;

    private Page<Archive> archives;

    @Inject
    private ArchiveService archiveService;
    @Inject
    private TypeService typeService;

    @Override
    protected BaseService<Archive, Long> getEntityService() {
        return archiveService;
    }

    public Resolution list() {

        List<Archive> archiveList = archiveService.findByPage(new Archive());

        if(archiveList == null){
            archiveList = Lists.newArrayList();
        }
        archives = new Page<Archive>(archiveList,archiveList.size());
        return new JsonResolution(archives);
    }
    @DefaultHandler
    public Resolution index(){
        return new ForwardResolution(LIST);
    }

    public Resolution form(){
        return new ForwardResolution(FORM);
    }

    public String getTypeList() {
        Type searchEntity = new Type();
        searchEntity.setIsShow(Boolean.TRUE);
        if(typeList == null || typeList.size() == 0){
            typeList = typeService.findByList(searchEntity);
        }
        if(typeList == null || typeList.size() == 0){
            return "\"\"";
        }
        Map<Long,String> maps = Maps.newHashMap();
        for (Type type : typeList) {
            maps.put(type.getId(), type.getName());
        }
        return new Gson().toJson(maps);
    }
}

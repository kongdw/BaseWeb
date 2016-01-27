package k0n9.comm.entity.search;

import k0n9.comm.entity.search.filter.SearchFilterHelper;
import k0n9.module.sys.entity.User;

/**
 * @author David Kong
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Searchable searchable = SearchRequest.newSearchable();
        searchable.addSearchFilter(SearchFilterHelper.newCondition("username_like", "kongdw"));
        searchable.addSearchFilter(SearchFilterHelper.newCondition("createDate_eq","2010-01-01"));
        searchable.addSearchFilter(SearchFilterHelper.newCondition("role.name_eq","SYS"));
        searchable.addSearchFilter("role.id",SearchOperator.in,new String[]{"1","3","4"});
        searchable.addSearchFilter("id",SearchOperator.in,new String[]{"1","2","3"});
        searchable.convert(User.class);
        System.out.println(searchable);
    }
}

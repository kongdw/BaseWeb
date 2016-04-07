package k0n9.common.web.bind;

import k0n9.common.entity.search.Searchable;
import k0n9.common.web.resolver.SearchableArgumentResolver;
import net.sourceforge.stripes.controller.ExecutionContext;

/**
 * @author David Kong
 * @version 1.0
 */
public class SearchablePropertyBinder {

    public static Searchable resolveArgument(ExecutionContext executionContext) {
        return (Searchable) new SearchableArgumentResolver().resolveArgument(executionContext);
    }
}

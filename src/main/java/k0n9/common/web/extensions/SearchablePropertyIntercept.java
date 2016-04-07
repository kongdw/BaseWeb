package k0n9.common.web.extensions;

import k0n9.common.entity.search.Searchable;
import k0n9.common.web.bind.SearchablePropertyBinder;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;

/**
 * @author David Kong
 * @version 1.0
 */
@Intercepts(LifecycleStage.BindingAndValidation)
public class SearchablePropertyIntercept implements Interceptor {
    @Override
    public Resolution intercept(ExecutionContext context) throws Exception {
        Resolution resolution = context.proceed();
        //ValidationErrors fieldErrors = new SearchablePropertyBinder().bind(bean, bean.getContext(), false);
        Searchable searchable = SearchablePropertyBinder.resolveArgument(context);
        System.out.println(searchable.toString());
        return resolution;
    }

}

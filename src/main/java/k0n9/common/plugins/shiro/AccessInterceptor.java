package k0n9.common.plugins.shiro;

import java.lang.reflect.Method;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;

import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.aop.AnnotationsAuthorizingMethodInterceptor;

/**
 * A Stripes Interceptor which will check if the given handler method has a {@link Require}
 * annotation, and checks from Shiro whether the user has access to it.  For example
 * <pre>
 *     public class AdminActionBean implements ActionBean
 *     {
 *        @DefaultHandler
 *        @RequiresRoles("admin")
 *        public Resolution doAdminThingies()
 *        {
 *           ...
 *        }
 *     }
 *  </pre>
 */
@Intercepts(LifecycleStage.HandlerResolution)
public class AccessInterceptor extends AnnotationsAuthorizingMethodInterceptor implements Interceptor {
    public Resolution intercept(ExecutionContext ctx) throws Exception {
        // First, execute the HandlerResolution
        Resolution resolution = ctx.proceed();

        MethodInvocation mi = new StripesMethodInvocation(ctx);

        // This throws a SecurityException if there's no access, which will
        // be caught by the ShiroFilter and acted upon.
        assertAuthorized(mi);

        return resolution;
    }

    /**
     * Private class which wraps the current ActionBean/Method invocation
     * information into a Shiro MethodInvocation.
     */
    private static class StripesMethodInvocation implements MethodInvocation {
        private ExecutionContext m_context;

        public StripesMethodInvocation(ExecutionContext ctx) {
            m_context = ctx;
        }

        public Object[] getArguments() {
            // Stripes handlers never get arguments, so this is cool.
            return null;
        }

        public Method getMethod() {
            return m_context.getHandler();
        }

        public Object getThis() {
            return m_context.getActionBean();
        }

        public Object proceed() throws Throwable {
            // This is not actually used by us
            return null;
        }

    }
}
package k0n9.common.plugins.stripes.security;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.Resolution;

import java.lang.reflect.Method;

/**
 * @author David Kong
 * @version 1.0
 */
public interface SecurityHandler {
    /**
     * Determines what to do when access has been denied.
     *
     * @param bean    the action bean to which access was denied
     * @param handler the event handler to which access was denied
     * @return the Resolution to be executed when access has been denied
     */
    Resolution handleAccessDenied(ActionBean bean, Method handler);
}
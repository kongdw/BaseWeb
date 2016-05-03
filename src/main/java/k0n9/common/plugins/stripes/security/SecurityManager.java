package k0n9.common.plugins.stripes.security;

import net.sourceforge.stripes.action.ActionBean;

import java.lang.reflect.Method;

/**
 * @author David Kong
 * @version 1.0
 */
public interface SecurityManager {
    /**
     * Determines if access for the given execution context is allowed. The security manager is used to determine if
     * access is allowed (to handle an event) or if access is not denied (thus allowing the display of error messages
     * for binding and/or validation errors for a secured event). If the latter would not be checked, a user can (even
     * if only theoretically) see an error message, correct his input, and then see an &quot;access forbidden&quot;
     * message. Using this design, such a case is only possible when hacking.
     * <p>
     * If required contextual information (like what data is affected) is not available, no decision should be made.
     * This is to ensure that access is not denied when required data is missing because of a binding and/or validation
     * error.
     *
     * @param bean    the action bean on which to perform the action
     * @param handler the event handler check authorization for
     * @return {@link Boolean#TRUE} if access is allowed, {@link Boolean#FALSE} if not, and null if no decision can be made
     */
    Boolean getAccessAllowed(ActionBean bean, Method handler);
}

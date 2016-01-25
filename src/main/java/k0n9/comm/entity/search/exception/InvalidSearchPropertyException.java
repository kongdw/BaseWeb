package k0n9.comm.entity.search.exception;

/**
 * @author David Kong
 * @version 1.0
 */
public class InvalidSearchPropertyException extends SearchException {

    private static final long serialVersionUID = 7125573987104011453L;

    public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
        this(searchProperty, entityProperty, null);
    }

    public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
        super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
    }
}

package k0n9.common.entity.search.exception;

/**
 * @author David Kong
 * @version 1.0
 */
public class InvalidSearchValueException extends SearchException {

    private static final long serialVersionUID = 8305046352185951650L;

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value) {
        this(searchProperty, entityProperty, value, null);
    }

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value, Throwable cause) {
        super("Invalid Search Value, searchProperty [" + searchProperty + "], " +
                "entityProperty [" + entityProperty + "], value [" + value + "]", cause);
    }

}
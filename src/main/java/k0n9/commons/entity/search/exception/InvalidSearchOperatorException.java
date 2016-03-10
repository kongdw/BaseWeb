package k0n9.commons.entity.search.exception;

import k0n9.commons.entity.search.SearchOperator;

/**
 * @author David Kong
 * @version 1.0
 */
public class InvalidSearchOperatorException extends SearchException {

    private static final long serialVersionUID = 2634635849340824203L;

    public InvalidSearchOperatorException(String searchProperty, String operatorStr) {
        this(searchProperty, operatorStr, null);
    }

    public InvalidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
        super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
                "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
    }
}

package k0n9.comm.entity.search.exception;

import k0n9.comm.exception.NestedRuntimeException;

/**
 * @author David Kong
 * @version 1.0
 */
public class SearchException extends NestedRuntimeException {

    private static final long serialVersionUID = -917631414677311288L;

    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
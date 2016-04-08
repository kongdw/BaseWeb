package k0n9.common.guice.exception;

import java.text.MessageFormat;

/**
 * @author David Kong
 * @version 1.0
 */
public class CreateClassException extends RuntimeException {
    private static final long serialVersionUID = -1863429800590983472L;

    public CreateClassException( String aMessage,  Throwable aCause) {
        super(aMessage, aCause);
    }

    
    public static CreateClassException createException( Exception anException,
                                                        String aClassName) {
        return new CreateClassException(MessageFormat.format("Exception when creating class {0}", aClassName), anException);
    }
}
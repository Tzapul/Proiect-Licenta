package ro.ucv.ace.exception;

/**
 * Created by tzapt on 6/21/2017.
 */
public class InvalidEmailFormat extends RuntimeException {

    public InvalidEmailFormat() {
    }

    public InvalidEmailFormat(String message) {
        super(message);
    }

    public InvalidEmailFormat(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmailFormat(Throwable cause) {
        super(cause);
    }

    public InvalidEmailFormat(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

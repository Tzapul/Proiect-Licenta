package ro.ucv.ace.exception;

/**
 * Created by tzapt on 12/4/2016.
 */
public class DeadlinePassedException extends RuntimeException {

    public DeadlinePassedException() {
    }

    public DeadlinePassedException(String message) {
        super(message);
    }

    public DeadlinePassedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeadlinePassedException(Throwable cause) {
        super(cause);
    }

    public DeadlinePassedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

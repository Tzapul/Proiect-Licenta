package ro.ucv.ace.exception;

/**
 * Created by tzapt on 6/20/2017.
 */
public class UsernameAlreadyUsed extends RuntimeException {

    public UsernameAlreadyUsed() {
    }

    public UsernameAlreadyUsed(String message) {
        super(message);
    }

    public UsernameAlreadyUsed(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameAlreadyUsed(Throwable cause) {
        super(cause);
    }

    public UsernameAlreadyUsed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

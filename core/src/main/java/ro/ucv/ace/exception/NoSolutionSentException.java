package ro.ucv.ace.exception;

/**
 * Created by tzapt on 12/10/2016.
 */
public class NoSolutionSentException extends DaoException {

    public NoSolutionSentException() {
    }

    public NoSolutionSentException(String message) {
        super(message);
    }

    public NoSolutionSentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSolutionSentException(Throwable cause) {
        super(cause);
    }

    public NoSolutionSentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

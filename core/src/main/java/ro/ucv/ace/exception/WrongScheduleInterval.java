package ro.ucv.ace.exception;

/**
 * Created by tzapt on 6/25/2017.
 */
public class WrongScheduleInterval extends RuntimeException {

    public WrongScheduleInterval() {
    }

    public WrongScheduleInterval(String message) {
        super(message);
    }

    public WrongScheduleInterval(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongScheduleInterval(Throwable cause) {
        super(cause);
    }

    public WrongScheduleInterval(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

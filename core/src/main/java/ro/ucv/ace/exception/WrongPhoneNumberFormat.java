package ro.ucv.ace.exception;

/**
 * Created by itsix on 26/06/2017.
 */
public class WrongPhoneNumberFormat extends RuntimeException {

    public WrongPhoneNumberFormat() {
    }

    public WrongPhoneNumberFormat(String message) {
        super(message);
    }

    public WrongPhoneNumberFormat(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPhoneNumberFormat(Throwable cause) {
        super(cause);
    }

    public WrongPhoneNumberFormat(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

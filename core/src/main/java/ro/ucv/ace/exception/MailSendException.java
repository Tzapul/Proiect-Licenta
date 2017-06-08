package ro.ucv.ace.exception;

/**
 * Created by Geo on 19.11.2016.
 */
public class MailSendException extends RuntimeException {
    public MailSendException() {
    }

    public MailSendException(String message) {
        super(message);
    }

    public MailSendException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailSendException(Throwable cause) {
        super(cause);
    }

    public MailSendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

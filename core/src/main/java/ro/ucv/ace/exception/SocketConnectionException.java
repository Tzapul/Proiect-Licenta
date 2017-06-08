package ro.ucv.ace.exception;

/**
 * Created by ctotolin on 20-Nov-16.
 */
public class SocketConnectionException extends RuntimeException{

    public SocketConnectionException() {}

    public SocketConnectionException(String message) {
        super(message);
    }

    public SocketConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocketConnectionException(Throwable cause) {
        super(cause);
    }

    public SocketConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

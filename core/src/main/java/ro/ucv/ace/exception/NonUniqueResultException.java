package ro.ucv.ace.exception;

/**
 * This exception is thrown when a unique result is expected, but more than one result is returned.
 *
 * @author Georgian Vladutu
 */
public class NonUniqueResultException extends DaoException {

    public NonUniqueResultException() {
    }

    public NonUniqueResultException(String message) {
        super(message);
    }

    public NonUniqueResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonUniqueResultException(Throwable cause) {
        super(cause);
    }

    public NonUniqueResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

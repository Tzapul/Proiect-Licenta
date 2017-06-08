package ro.ucv.ace.exception;

/**
 * This exception is thrown when a save or update operation occurs and a field that is set as unique already exists.
 *
 * @author Georgian Vladutu
 */
public class DuplicateEntryException extends DaoException {

    public DuplicateEntryException() {
    }

    public DuplicateEntryException(String message) {
        super(message);
    }

    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntryException(Throwable cause) {
        super(cause);
    }

    public DuplicateEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

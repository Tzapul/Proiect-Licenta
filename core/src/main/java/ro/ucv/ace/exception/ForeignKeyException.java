package ro.ucv.ace.exception;

/**
 * This exception is thrown on a save or update operation when an entity has a OneToOne, OneToMany or ManyToMany relationship
 * and the other entity in the relationship is not found.
 *
 * @author Georgian Vladutu
 */
public class ForeignKeyException extends DaoException {

    public ForeignKeyException() {
    }

    public ForeignKeyException(String message) {
        super(message);
    }

    public ForeignKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForeignKeyException(Throwable cause) {
        super(cause);
    }

    public ForeignKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

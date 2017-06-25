package ro.ucv.ace.exception;

/**
 * Created by tzapt on 6/25/2017.
 */
public class NoMoreFreePlacesAtTables extends RuntimeException {

    public NoMoreFreePlacesAtTables() {
    }

    public NoMoreFreePlacesAtTables(String message) {
        super(message);
    }

    public NoMoreFreePlacesAtTables(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreFreePlacesAtTables(Throwable cause) {
        super(cause);
    }

    public NoMoreFreePlacesAtTables(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

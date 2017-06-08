package ro.ucv.ace.exception;

/**
 * Created by tzapt on 11/16/2016.
 */
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String s) {
        super(s);
    }
}

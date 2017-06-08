package ro.ucv.ace.error;

import org.springframework.http.HttpStatus;

/**
 * This class contains information about an error.
 *
 * @author Georgian Alexnadru
 */
public class ErrorInfo {

    protected int statusCode;

    protected String message;

    protected String status;

    public ErrorInfo(HttpStatus httpStatus, String message) {
        this.statusCode = httpStatus.value();
        this.message = message;
        this.status = httpStatus.toString();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

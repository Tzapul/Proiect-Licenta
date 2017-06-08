package ro.ucv.ace.error;

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * This class contains information about a binding error.
 *
 * @author Georgian Alexnadru
 */
public class BindingErrorInfo extends ErrorInfo {

    private List<FieldErrorInfo> fieldErrors;

    public BindingErrorInfo(HttpStatus status, String message, List<FieldErrorInfo> fieldErrors) {
        super(status, message);
        this.fieldErrors = fieldErrors;
    }

    public List<FieldErrorInfo> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorInfo> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}


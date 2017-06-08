package ro.ucv.ace.error;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a populator.
 *
 * @author Georgian Vladutu
 */
@Component
public class ErrorInfoPopulator {

    /**
     * Populates a BindingErrorInfo object using the method parameters.
     *
     * @param errors  list of FieldError
     * @param message message
     * @param status  htttp status
     * @return BindingErrorInfo
     */
    public BindingErrorInfo populate(List<FieldError> errors, String message, HttpStatus status) {
        List<FieldErrorInfo> fieldErrors = new ArrayList<>();
        for (FieldError error : errors) {
            FieldErrorInfo fieldError = new FieldErrorInfo(error.getField(), error.getDefaultMessage());
            fieldErrors.add(fieldError);
        }

        return new BindingErrorInfo(status, message, fieldErrors);
    }
}

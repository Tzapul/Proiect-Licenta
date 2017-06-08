package ro.ucv.ace.exception;

import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Created by Geo on 16.11.2016.
 */
public class EntityBindingException extends RuntimeException {

    private List<FieldError> errors;

    public EntityBindingException(List<FieldError> errors) {
        super("There was a problem with your request. Please check if the fields are correct.");
        this.errors = errors;
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}

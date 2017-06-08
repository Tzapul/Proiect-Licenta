package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.error.BindingErrorInfo;
import ro.ucv.ace.error.ErrorInfo;
import ro.ucv.ace.error.ErrorInfoPopulator;
import ro.ucv.ace.exception.*;

/**
 * This class is a controller advice that handles all exception thrown from the REST controllers.
 *
 * @author Georgian Alexandru
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalControllerAdvice {

    @Autowired
    private ErrorInfoPopulator errorInfoPopulator;

    @ExceptionHandler(EntityBindingException.class)
    public ResponseEntity<BindingErrorInfo> bindingException(EntityBindingException exception) {
        BindingErrorInfo bindingErrorInfo = errorInfoPopulator.populate(exception.getErrors(), exception.getMessage(),
                HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(bindingErrorInfo, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErrorInfo> duplicateEntryException(DuplicateEntryException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorInfo> entityNotFoundException(EntityNotFoundException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForeignKeyException.class)
    public ResponseEntity<ErrorInfo> foreignKeyException(ForeignKeyException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<ErrorInfo> nonUniqueResultException(NonUniqueResultException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorInfo> invalidPasswordException(InvalidPasswordException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeadlinePassedException.class)
    public ResponseEntity<ErrorInfo> errorInfoResponseEntity(DeadlinePassedException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSolutionSentException.class)
    public ResponseEntity<ErrorInfo> noSolutionException(NoSolutionSentException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

}

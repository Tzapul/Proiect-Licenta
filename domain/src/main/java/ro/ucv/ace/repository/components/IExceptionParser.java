package ro.ucv.ace.repository.components;

import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;

/**
 * Interface which provides methods to modify the plain messages returned by the JPA exception.
 *
 * @author Georgian Vladutu
 */
public interface IExceptionParser {

    /**
     * Parses the message of a JpaSystemException object and returns the new message.
     *
     * @param e     JpaSystemException object
     * @param clazz the class of the entity which caused the exception
     * @return String the new message
     */
    String parsePersistenceException(JpaSystemException e, Class<?> clazz);

    /**
     * Parses the message of a JpaObjectRetrievalFailureException object and returns the new message.
     *
     * @param e JpaObjectRetrievalFailureException object
     * @return String the new message
     */
    String parseEntityNotFoundException(JpaObjectRetrievalFailureException e);

}
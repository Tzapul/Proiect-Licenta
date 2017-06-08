package ro.ucv.ace.repository.components;

import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

/**
 * This class implements IExceptionParser interface.
 *
 * @author Georgian Vladutu
 */
@Component
public class ExceptionParserImpl implements IExceptionParser {

    @Override
    public String parsePersistenceException(JpaSystemException e, Class<?> clazz) {
        String unformattedMessage = e.getCause().getCause().getCause().toString();
        String className = getDisplayName(clazz);
        String[] tokens = unformattedMessage.split(" ");

        return createString(className, ": ", tokens[1], " ", tokens[2], " ", tokens[3]);
    }

    private String getDisplayName(Class<?> clazz) {
        String displayName = clazz.getSimpleName();

        if (clazz.getInterfaces().length > 0) {
            displayName = clazz.getInterfaces()[0].getSimpleName();
        }

        return displayName;
    }

    @Override
    public String parseEntityNotFoundException(JpaObjectRetrievalFailureException e) {
        String unformattedMessage = e.getMessage();
        String tokens[] = unformattedMessage.split(" ");
        String className = tokens[3].split("\\.")[4];

        return createString("Unable to find " + className + " with id " + tokens[6]);
    }

    private String createString(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }
}
package ro.ucv.ace.socket;

/**
 * Created by ctotolin on 25-Nov-16.
 */
public interface IJobResult {

    boolean getError();

    String getResult();

    boolean getInternalError();
}

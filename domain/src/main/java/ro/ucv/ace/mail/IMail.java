package ro.ucv.ace.mail;

/**
 * Created by Geo on 19.11.2016.
 */
public interface IMail {
    String getFrom();

    String getTo();

    String getSubject();

    Object getBody();
}

package ro.ucv.ace.service;

/**
 * Created by Geo on 19.11.2016.
 */
public interface IMailService {

    void sendAccountCreationMail(String to, String username, String password);
}

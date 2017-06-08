package ro.ucv.ace.mail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ro.ucv.ace.exception.MailSendException;
import ro.ucv.ace.mail.IMailSender;
import ro.ucv.ace.mail.IMail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Geo on 19.11.2016.
 */
@Component
public class MailSender implements IMailSender {

    @Autowired
    private Environment environment;


    private Session createSession() {
        String mailUsername = environment.getRequiredProperty("mail.smtp.username");
        String mailPassword = environment.getRequiredProperty("mail.smtp.password");

        Properties props = new Properties();
        props.put("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
        props.put("mail.smtp.host", environment.getRequiredProperty("mail.smtp.host"));
        props.put("mail.smtp.port", environment.getRequiredProperty("mail.smtp.port"));

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailUsername, mailPassword);
            }
        });
    }

    @Override
    public void sendMail(IMail mail) {
        try {
            Message message = new MimeMessage(createSession());
            message.setFrom(new InternetAddress(mail.getFrom(), "E-App"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo()));
            message.setSubject(mail.getSubject());
            message.setContent(mail.getBody(), "text/html; charset=utf-8");

            Transport.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new MailSendException("Unable to send the mail. Original message was: " + e.getMessage());
        }

    }
}

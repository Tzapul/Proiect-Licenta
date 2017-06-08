package ro.ucv.ace.mail.impl;

import ro.ucv.ace.mail.IMail;

/**
 * Created by Geo on 19.11.2016.
 */
public class NewAccountMail implements IMail {

    private String to;

    private String username;

    private String password;

    public NewAccountMail(String to, String username, String password) {
        this.to = to;
        this.username = username;
        this.password = password;
    }

    @Override
    public String getFrom() {
        return "wad_team2@ace.ucv.ro";
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getSubject() {
        return "Welcome to E-app!";
    }

    @Override
    public Object getBody() {
        StringBuilder builder = new StringBuilder("");
        builder.append("<h1>Welcome to E-app </h1>");
        builder.append("<p> Your account has been created.</p>");
        builder.append("<p> Username: <b>");
        builder.append(username);
        builder.append("</b></p>");
        builder.append("<p> Password: <b>");
        builder.append(password);
        builder.append("</b></p>");

        return builder.toString();
    }
}

package ro.ucv.ace.model;

import ro.ucv.ace.visitor.ClientVisitor;
import ro.ucv.ace.visitor.UserVisitor;

import javax.persistence.*;

/**
 * Created by tzapt on 6/20/2017.
 */
@Entity
@Table(name = "CLIENT")
public class Client extends User {

    public Client() {
    }

    public Client(String firstName, String lastName, String phoneNumber, String email, String username, String password) {
        PersonDetails personDetails = new PersonDetails(firstName, lastName, phoneNumber);
        Account account = new Account(email, username, password, this);

        this.setAccount(account);
        this.setPersonDetails(personDetails);
    }

    public void accept(ClientVisitor clientVisitor) {
        clientVisitor.visit(this);
    }
}

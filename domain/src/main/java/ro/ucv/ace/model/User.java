package ro.ucv.ace.model;

import ro.ucv.ace.visitor.UserVisitor;

import javax.persistence.*;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Client{

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "user")
    private Account account;

    @Embedded
    private PersonDetails personDetails;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, String email, String username, String password,
                String notificationKey) {
        super(notificationKey);
        PersonDetails personDetails = new PersonDetails(firstName, lastName, phoneNumber);
        Account account = new Account(email, username, password, this);

        this.setAccount(account);
        this.setPersonDetails(personDetails);
    }

    public boolean passwordMatches(String password) {
        return account.passwordMatches(password);
    }

    public void accept(UserVisitor userVisitor) {
        userVisitor.visit(this);
    }

    public String getUsername() {
        return account.getUsername();
    }

    public String getPassword() {
        return account.getPassword();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public void update(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.personDetails.update(firstName, lastName, phoneNumber);
        this.account.update(email, password);
    }
}

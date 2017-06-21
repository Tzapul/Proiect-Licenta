package ro.ucv.ace.model;

import ro.ucv.ace.model.enums.Gender;

import javax.persistence.*;

/**
 * Created by Geo on 15.11.2016.
 */
@Embeddable
public class PersonDetails {

    @Column(name = "FIRST_NAME", nullable = false)
    @Basic
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @Basic
    private String lastName;

    @Column(name = "PHONE", nullable = false)
    @Basic
    private String phoneNumber;

    public PersonDetails() {
    }

    public PersonDetails(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

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

    @Column(name = "SSN", nullable = false, unique = true)
    @Basic
    private String ssn;

    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonDetails() {

    }

    public PersonDetails(String firstName, String lastName, String ssn, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.gender = Gender.valueOf(gender);
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

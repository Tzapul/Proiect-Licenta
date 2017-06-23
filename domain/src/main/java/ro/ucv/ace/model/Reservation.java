package ro.ucv.ace.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/10/2017.
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @Basic
    private String name;

    @Column(name = "EMAIL")
    @Basic
    private String email;

    @Column(name = "DATE")
    @Basic
    private LocalDate date;

    @Column(name = "PHONE")
    @Basic
    private String phoneNumber;

    @Column(name = "PEOPLE")
    @Basic
    private Integer people;

    @ManyToMany
    @JoinTable(name = "RESERVATION_TABLES", joinColumns = @JoinColumn(name = "RESERVATION_DATE", referencedColumnName = "DATE")
            , inverseJoinColumns = @JoinColumn(name = "TABLE_ID", referencedColumnName = "ID"))
    private List<Tables> tables = new ArrayList<>();

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }
}

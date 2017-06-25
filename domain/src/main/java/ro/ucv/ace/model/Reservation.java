package ro.ucv.ace.model;

import ro.ucv.ace.visitor.ReservationVisitor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/10/2017.
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @Basic
    private String name;

    @Column(name = "RESERVATION_EMAIL")
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
    @JoinTable(name = "RESERVATION_TABLES", joinColumns = @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "ID")
            , inverseJoinColumns = @JoinColumn(name = "TABLE_ID", referencedColumnName = "ID"))
    private List<Tables> tables = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", nullable = false)
    private Client client;

    public Reservation() {
    }

    public Reservation(String name, String email, LocalDate date, String phoneNumber, Integer people, List<Tables> tables, Client client) {
        this.name = name;
        this.email = email;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.people = people;
        this.tables = tables;
        this.client = client;
//        client.addReservation(this);
//        for(Tables table: tables) {
//            table.addReservation(this);
//        }
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

    public List<Tables> getTables() {
        return tables;
    }

    public void setTables(List<Tables> tables) {
        this.tables = tables;
    }

    public void accept(ReservationVisitor reservationVisitor) {
        reservationVisitor.visit(this);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

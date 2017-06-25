package ro.ucv.ace.model;

import ro.ucv.ace.visitor.TableVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itsix on 22/06/2017.
 */
@Entity
@Table(name = "Tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TABLE_NAME")
    @Basic
    private String name;

    @Column(name = "NO_OF_PEOPLE")
    @Basic
    private int noOfPeople;

    @ManyToMany(mappedBy = "tables")
    private List<Reservation> reservations = new ArrayList<>();

    public Tables() {
    }

    public Tables(String name, int noOfPeople) {
        this.name = name;
        this.noOfPeople = noOfPeople;
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

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void accept(TableVisitor tableVisitor) {
        tableVisitor.visit(this);
    }
}

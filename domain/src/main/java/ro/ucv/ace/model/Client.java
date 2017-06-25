package ro.ucv.ace.model;

import ro.ucv.ace.visitor.ClientVisitor;
import ro.ucv.ace.visitor.UserVisitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/20/2017.
 */
@Entity
@Table(name = "CLIENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Reservation> resevations = new ArrayList<>();

    public Client() {
    }

    public List<Reservation> getResevations() {
        return resevations;
    }

    public void setResevations(List<Reservation> resevations) {
        this.resevations = resevations;
    }

    public void accept(ClientVisitor clientVisitor) {
        clientVisitor.visit(this);
    }

    public void addReservation(Reservation reservation) {
        this.resevations.add(reservation);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

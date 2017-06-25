package ro.ucv.ace.model;

import ro.ucv.ace.visitor.DaysOffVisitor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tzapt on 6/15/2017.
 */
@Entity
@Table(name = "DaysOff")
public class DaysOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE", unique = true)
    private Date date;

    public DaysOff() {
    }

    public DaysOff(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void accept(DaysOffVisitor daysOffVisitor) {
        daysOffVisitor.visit(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

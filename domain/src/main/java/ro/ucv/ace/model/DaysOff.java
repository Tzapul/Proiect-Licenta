package ro.ucv.ace.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tzapt on 6/15/2017.
 */
@Entity
@Table(name = "DaysOff")
public class DaysOff {

    @Id
    @Temporal(TemporalType.DATE)
    private Date date;

    public DaysOff() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

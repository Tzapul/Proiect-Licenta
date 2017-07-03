package ro.ucv.ace.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by tzapt on 6/25/2017.
 */
@Entity
@Table(name = "GUEST")
public class Guest extends Client {

    public Guest() {
    }

    public Guest(String notificaionKey) {
        super(notificaionKey);
    }
}

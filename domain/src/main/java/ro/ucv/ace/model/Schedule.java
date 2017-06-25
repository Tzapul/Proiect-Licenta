package ro.ucv.ace.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/10/2017.
 */
@Entity
@Table(name = "SCHEDULE")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer iD;

    public Schedule() {
    }
}

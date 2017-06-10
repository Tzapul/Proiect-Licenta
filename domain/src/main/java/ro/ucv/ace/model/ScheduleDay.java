package ro.ucv.ace.model;

import ro.ucv.ace.model.enums.Day;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by tzapt on 6/10/2017.
 */
@Entity
@Table(name = "SCHEDULE_DAY")
public class ScheduleDay {

    @Id
    @Column(name = "DAY")
    private Day day;

    @Column(name = "FROM")
    @Basic
    private Integer from;

    @Column(name = "TO")
    @Basic
    private Integer to;

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "ID")
    private Schedule schedule;

    public ScheduleDay() {
    }


}

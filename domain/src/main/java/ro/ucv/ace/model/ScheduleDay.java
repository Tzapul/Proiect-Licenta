package ro.ucv.ace.model;

import org.springframework.context.annotation.Primary;
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
    @Enumerated(EnumType.STRING)
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

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}

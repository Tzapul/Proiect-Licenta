package ro.ucv.ace.model;

import ro.ucv.ace.model.enums.Day;

import javax.persistence.*;

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

    @Column(name = "START")
    @Basic
    private Integer start;

    @Column(name = "END")
    @Basic
    private Integer end;

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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}

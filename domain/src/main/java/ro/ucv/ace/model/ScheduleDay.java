package ro.ucv.ace.model;

import ro.ucv.ace.model.enums.Day;
import ro.ucv.ace.visitor.ScheduleDayVisitor;

import javax.persistence.*;

/**
 * Created by tzapt on 6/10/2017.
 */
@Entity
@Table(name = "SCHEDULE_DAY")
public class ScheduleDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "WEEK_DAY", unique = true)
    @Enumerated(EnumType.STRING)
    private Day day;

    @Column(name = "START")
    @Basic
    private Integer start;

    @Column(name = "END")
    @Basic
    private Integer end;

    public ScheduleDay() {
    }

    public ScheduleDay(Day day, Integer start, Integer end) {
        this.day = day;
        this.start = start;
        this.end = end;
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

    public void accept(ScheduleDayVisitor scheduleDayVisitor) {
        scheduleDayVisitor.visit(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void update(int start, Integer end) {
        this.start = start;
        this.end = end;
    }
}

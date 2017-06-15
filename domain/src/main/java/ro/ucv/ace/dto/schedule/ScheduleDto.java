package ro.ucv.ace.dto.schedule;

import ro.ucv.ace.model.ScheduleDay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
public class ScheduleDto {

    private int id;

    private List<ScheduleDay> days = new ArrayList<>();

    public ScheduleDto(int id, List<ScheduleDay> days) {
        this.id = id;
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ScheduleDay> getDays() {
        return days;
    }

    public void setDays(List<ScheduleDay> days) {
        this.days = days;
    }
}

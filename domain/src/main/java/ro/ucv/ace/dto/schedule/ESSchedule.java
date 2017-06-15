package ro.ucv.ace.dto.schedule;

import ro.ucv.ace.model.ScheduleDay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
public class ESSchedule {

    private List<ScheduleDay> days = new ArrayList<>();

    public ESSchedule(List<ScheduleDay> days) {
        this.days = days;
    }

    public List<ScheduleDay> getDays() {
        return days;
    }

    public void setDays(List<ScheduleDay> days) {
        this.days = days;
    }
}

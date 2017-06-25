package ro.ucv.ace.dto.scheduleDay;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by tzapt on 6/25/2017.
 */
public class ScheduleDayDto {

    private int id;

    private String day;

    @Min(0)
    @Max(24)
    private int start;

    @Min(0)
    @Max(24)
    private int end;

    public ScheduleDayDto() {
    }

    public ScheduleDayDto(String day, int start, int end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

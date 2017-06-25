package ro.ucv.ace.dto.scheduleDay;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by tzapt on 6/25/2017.
 */
public class EScheduleDayDto {

    @Min(0)
    @Max(24)
    private int start;

    @Min(0)
    @Max(24)
    private int end;

    public EScheduleDayDto() {
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
}

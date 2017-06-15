package ro.ucv.ace.dto.daysOff;

/**
 * Created by tzapt on 6/15/2017.
 */
public class DaysOffDto {

    private String date;

    public DaysOffDto(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

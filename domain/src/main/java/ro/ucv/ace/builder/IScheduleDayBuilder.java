package ro.ucv.ace.builder;

import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.model.ScheduleDay;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IScheduleDayBuilder {
    ScheduleDay build(ScheduleDayDto scheduleDayDto);
}

package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IScheduleDayBuilder;
import ro.ucv.ace.dto.client.ESClientDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.ScheduleDay;
import ro.ucv.ace.model.enums.Day;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class ScheduleDayBuilder implements IScheduleDayBuilder {

    @Override
    public ScheduleDay build(ScheduleDayDto scheduleDayDto) {
        return new ScheduleDay(Day.valueOf(scheduleDayDto.getDay()), scheduleDayDto.getStart(), scheduleDayDto.getEnd());
    }
}

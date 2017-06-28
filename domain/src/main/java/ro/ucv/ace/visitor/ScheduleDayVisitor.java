package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.client.ClientDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.ScheduleDay;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class ScheduleDayVisitor {

    private ScheduleDayDto scheduleDayDto;

    public void visit(ScheduleDay scheduleDay) {
        scheduleDayDto = new ScheduleDayDto(scheduleDay.getId(), scheduleDay.getDay().toString(), scheduleDay.getStart(), scheduleDay.getEnd());
    }

    public ScheduleDayDto getScheduleDayDto() {
        return scheduleDayDto;
    }
}

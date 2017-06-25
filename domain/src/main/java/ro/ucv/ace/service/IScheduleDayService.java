package ro.ucv.ace.service;

import ro.ucv.ace.dto.scheduleDay.EScheduleDayDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;

import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IScheduleDayService {
    List<ScheduleDayDto> getAllScheduleDays();

    ScheduleDayDto save(ScheduleDayDto daysOffDto);

    ScheduleDayDto delete(int id);

    ScheduleDayDto update(EScheduleDayDto scheduleDayDto, int id);
}

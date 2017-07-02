package ro.ucv.ace.repository;

import ro.ucv.ace.model.ScheduleDay;

import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IScheduleDayRepository {
    ScheduleDay save(ScheduleDay scheduleDay);

    List<ScheduleDay> findAll();

    ScheduleDay delete(int id);

    ScheduleDay findOne(int id);

    ScheduleDay findByDay(String s);
}

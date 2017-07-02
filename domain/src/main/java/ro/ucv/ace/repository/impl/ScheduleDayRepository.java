package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.ScheduleDay;
import ro.ucv.ace.model.enums.Day;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IScheduleDayRepository;

import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@Repository("scheduleDayRepository")
public class ScheduleDayRepository implements IScheduleDayRepository {

    @Autowired
    private IJpaRepository<ScheduleDay, Integer> innerScheduleDayRepository;

    @Override
    public ScheduleDay save(ScheduleDay scheduleDay) {
        return innerScheduleDayRepository.save(scheduleDay);
    }

    @Override
    public List<ScheduleDay> findAll() {
        return innerScheduleDayRepository.findAll();
    }

    @Override
    public ScheduleDay delete(int id) {
        return innerScheduleDayRepository.delete(id);
    }

    @Override
    public ScheduleDay findOne(int id) { return innerScheduleDayRepository.findOne(id); }

    @Override
    public ScheduleDay findByDay(String day) {
        return innerScheduleDayRepository.findOneWhere(sd -> sd.getDay().equals(Day.valueOf(day)));
    }
}

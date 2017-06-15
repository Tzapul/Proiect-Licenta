package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.model.Schedule;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IScheduleRepository;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@Repository("scheduleRepository")
public class ScheduleRepository implements IScheduleRepository {

    @Autowired
    private IJpaRepository<Schedule, Integer> innerScheduleRepository;

    @Override
    public Schedule save(Schedule schedule) {
        return innerScheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> findAll() {
        return innerScheduleRepository.findAll();
    }

    @Override
    public Schedule delete(int id) {
        return innerScheduleRepository.delete(id);
    }

    @Override
    public Schedule findOne(int id) { return innerScheduleRepository.findOne(id); }
}

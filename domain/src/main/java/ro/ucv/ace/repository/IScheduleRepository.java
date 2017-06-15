package ro.ucv.ace.repository;

import ro.ucv.ace.model.Schedule;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
public interface IScheduleRepository {

    Schedule save(Schedule schedule);

    List<Schedule> findAll();

    Schedule delete(int id);

    Schedule findOne(int id);
}

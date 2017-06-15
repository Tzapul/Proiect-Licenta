package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.DaysOff;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.model.Schedule;
import ro.ucv.ace.repository.IDaysOffRepository;
import ro.ucv.ace.repository.IJpaRepository;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@Repository("daysOffRepository")
public class DaysOffRepository implements IDaysOffRepository {

    @Autowired
    private IJpaRepository<DaysOff, Integer> innerDaysOffRepository;

    @Override
    public DaysOff save(DaysOff daysOff) {
        return innerDaysOffRepository.save(daysOff);
    }

    @Override
    public List<DaysOff> findAll() {
        return innerDaysOffRepository.findAll();
    }

    @Override
    public DaysOff delete(int id) {
        return innerDaysOffRepository.delete(id);
    }

    @Override
    public DaysOff findOne(int id) { return innerDaysOffRepository.findOne(id); }
}

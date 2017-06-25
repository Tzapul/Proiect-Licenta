package ro.ucv.ace.repository;

import ro.ucv.ace.model.DaysOff;
import ro.ucv.ace.model.Reservation;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
public interface IDaysOffRepository {

    DaysOff save(DaysOff reservation);

    List<DaysOff> findAll();

    DaysOff delete(int id);

    DaysOff findOne(int id);

}

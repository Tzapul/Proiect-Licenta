package ro.ucv.ace.repository;

import ro.ucv.ace.model.Reservation;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
public interface IReservationRepository {

    Reservation save(Reservation reservation);

    List<Reservation> findAll();

    Reservation delete(int id);

    Reservation findOne(int id);
}

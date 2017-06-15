package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Professor;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IReservationRepository;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@Repository("reservationRepository")
public class ReservationRepository implements IReservationRepository {

    @Autowired
    private IJpaRepository<Reservation, Integer> innerReservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return innerReservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return innerReservationRepository.findAll();
    }

    @Override
    public Reservation delete(int id) {
        return innerReservationRepository.delete(id);
    }

    @Override
    public Reservation findOne(int id) { return innerReservationRepository.findOne(id); }

}

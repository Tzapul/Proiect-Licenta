package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.DaysOff;
import ro.ucv.ace.model.Guest;
import ro.ucv.ace.model.Student;
import ro.ucv.ace.repository.IGuestRepository;
import ro.ucv.ace.repository.IJpaRepository;

import java.util.List;

/**
 * Created by itsix on 26/06/2017.
 */
@Repository("guestRepository")
public class GuestRepository implements IGuestRepository {

    @Autowired
    private IJpaRepository<Guest, Integer> innerGuestRepository;

    @Override
    public Guest save(Guest guest) {
        return innerGuestRepository.save(guest);
    }

    @Override
    public List<Guest> findAll() {
        return innerGuestRepository.findAll();
    }

    @Override
    public Guest delete(int id) {
        return innerGuestRepository.delete(id);
    }

    @Override
    public Guest findOne(int id) {
        return innerGuestRepository.findOne(id);
    }
}

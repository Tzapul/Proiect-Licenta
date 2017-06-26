package ro.ucv.ace.repository;

import ro.ucv.ace.model.Guest;

import java.util.List;

/**
 * Created by itsix on 26/06/2017.
 */
public interface IGuestRepository {
    Guest save(Guest guest);

    List<Guest> findAll();

    Guest delete(int id);

    Guest findOne(int id);
}

package ro.ucv.ace.builder;

import ro.ucv.ace.dto.reservation.ESReservationDto;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.model.Tables;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IReservationBuilder {

    Reservation build(ESReservationDto esReservationDto, List<Tables> tablesToBeGiven, Client client);
}

package ro.ucv.ace.service;

import ro.ucv.ace.dto.reservation.ESReservationDto;
import ro.ucv.ace.dto.reservation.ReservationDto;

/**
 * Created by tzapt on 6/15/2017.
 */
public interface IReservationService {

    ReservationDto save(ESReservationDto esReservationDto, int id);

    ReservationDto delete(int id);
}

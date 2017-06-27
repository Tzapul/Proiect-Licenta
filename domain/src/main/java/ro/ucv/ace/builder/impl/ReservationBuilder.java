package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IReservationBuilder;
import ro.ucv.ace.converter.StringConverter;
import ro.ucv.ace.dto.reservation.ESReservationDto;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.model.Tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class ReservationBuilder implements IReservationBuilder {

    @Override
    public Reservation build(ESReservationDto esReservationDto, List<Tables> tablesToBeGiven, Client client) {
        return new Reservation(esReservationDto.getName(), esReservationDto.getEmail(),
                StringConverter.toLocalDate(esReservationDto.getDate()), esReservationDto.getHour(),
                esReservationDto.getPhone(), esReservationDto.getPeople(), tablesToBeGiven, client);
    }

}

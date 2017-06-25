package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IReservationBuilder;
import ro.ucv.ace.converter.StringConverter;
import ro.ucv.ace.dto.reservation.ESReservationDto;
import ro.ucv.ace.dto.reservation.ReservationDto;
import ro.ucv.ace.exception.NoMoreFreePlacesAtTables;
import ro.ucv.ace.model.*;
import ro.ucv.ace.repository.IClientRepository;
import ro.ucv.ace.repository.IReservationRepository;
import ro.ucv.ace.repository.ITablesRepository;
import ro.ucv.ace.service.IReservationService;
import ro.ucv.ace.visitor.ReservationVisitor;

import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@Service("reservationService")
@Transactional(rollbackFor = Exception.class)
public class ReservationService implements IReservationService{

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private ITablesRepository tablesRepository;

    @Autowired
    private IReservationBuilder reservationBuilder;

    @Autowired
    private ReservationVisitor reservationVisitor;

    @Override
    public ReservationDto save(ESReservationDto esReservationDto, int id) {

        Client client = clientRepository.findOne(id);

        int people = esReservationDto.getPeople();
        int maxPeople = 0;

        String stringDate = esReservationDto.getDate();
        LocalDate date = StringConverter.toLocalDate(stringDate);

        List<Tables> freeTables = tablesRepository.findAllFreeTablesForDate(date);

        for (Tables table:  freeTables) {
            maxPeople += table.getNoOfPeople();
        }

        if(people > maxPeople) {
            throw new NoMoreFreePlacesAtTables("There are no more free places for that many people!");
        }

        List<Tables> tablesToBeGiven = new ArrayList<>();
        maxPeople = 0;
        for(Tables table: freeTables) {
            maxPeople += table.getNoOfPeople();
            tablesToBeGiven.add(table);
            if(maxPeople >= people) {
                break;
            }
        }

        Reservation reservation = reservationRepository.save(reservationBuilder.build(esReservationDto, tablesToBeGiven, client));

        reservation.accept(reservationVisitor);

        return reservationVisitor.getReservation();
    }

    @Override
    public ReservationDto delete(int id) {
        Reservation reservation = reservationRepository.delete(id);
        reservation.accept(reservationVisitor);
        return reservationVisitor.getReservation();
    }

}

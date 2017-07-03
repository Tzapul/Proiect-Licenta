package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IReservationBuilder;
import ro.ucv.ace.comparator.TablePlacesComparator;
import ro.ucv.ace.converter.StringConverter;
import ro.ucv.ace.dto.reservation.ESReservationDto;
import ro.ucv.ace.dto.reservation.ReservationDto;
import ro.ucv.ace.exception.NoMoreFreePlacesAtTables;
import ro.ucv.ace.helper.IAnotherHourFinder;
import ro.ucv.ace.helper.IOptimalTableFinder;
import ro.ucv.ace.model.*;
import ro.ucv.ace.repository.IClientRepository;
import ro.ucv.ace.repository.IReservationRepository;
import ro.ucv.ace.repository.ITablesRepository;
import ro.ucv.ace.service.IReservationService;
import ro.ucv.ace.visitor.ReservationVisitor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    @Autowired
    private IOptimalTableFinder optimalTableFinder;

    @Autowired
    private TablePlacesComparator tablePlacesComparator;

    @Autowired
    private IAnotherHourFinder anotherHourFinder;

    @Override
    public ReservationDto save(ESReservationDto esReservationDto, int id) {

        Client client = clientRepository.findOne(id);

        int people = esReservationDto.getPeople();
        int maxPeople = 0;

        String stringDate = esReservationDto.getDate();
        LocalDate date = StringConverter.toLocalDate(stringDate);

        List<Tables> freeTables = tablesRepository.findAllFreeTablesForDateAndHour(date, esReservationDto.getHour());

        for (Tables table:  freeTables) {
            maxPeople += table.getNoOfPeople();
        }

        if(people > maxPeople) {
            int greaterHour = anotherHourFinder.findHourGreaterThan(esReservationDto.getHour(), people, esReservationDto.getDate());
            int lesserHour = anotherHourFinder.findHourLesserThan(esReservationDto.getHour(), people, esReservationDto.getDate());

            if(greaterHour == -1 && lesserHour == -1) {
                throw new NoMoreFreePlacesAtTables("There are no more free places for that many people!");
            }

        }

        Collections.sort(freeTables, tablePlacesComparator);

        List<Tables> optimalTables = optimalTableFinder.getOptimalTables(people, freeTables);

        Reservation reservation = reservationRepository.save(reservationBuilder.build(esReservationDto, optimalTables, client));

        reservation.accept(reservationVisitor);

        return reservationVisitor.getReservation();
    }

    @Override
    public ReservationDto delete(int id) {
        Reservation reservation = reservationRepository.delete(id);
        reservation.accept(reservationVisitor);
        return reservationVisitor.getReservation();
    }

    @Override
    public List<ReservationDto> getAllReservationsForUser(int id) {
        List<Reservation> reservations = reservationRepository.getAllReservationsForUser(id);
        List<ReservationDto> reservationDtos = new ArrayList<>();

        reservations.forEach(r -> {
            r.accept(reservationVisitor);
            reservationDtos.add(reservationVisitor.getReservation());
        });

        return reservationDtos;
    }

}

package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.reservation.ReservationDto;
import ro.ucv.ace.dto.solution.SolutionDto;
import ro.ucv.ace.model.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class ReservationVisitor {
    private ReservationDto reservationDto;

    public void visit(Reservation reservation) {
        List<String> tableNames = new ArrayList<>();
        reservation.getTables().forEach(table -> tableNames.add(table.getName()));
        reservationDto = new ReservationDto(reservation.getId(), reservation.getName(), reservation.getEmail(),
                reservation.getDate().toString(), reservation.getPhoneNumber(), reservation.getPeople(), tableNames);
    }

    public ReservationDto getReservation() {
        return reservationDto;
    }
}

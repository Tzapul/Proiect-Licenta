package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.professor.ProfessorDto;
import ro.ucv.ace.dto.reservation.ESReservationDto;
import ro.ucv.ace.dto.reservation.ReservationDto;
import ro.ucv.ace.dto.student.ESStudentDto;
import ro.ucv.ace.dto.student.StudentDto;
import ro.ucv.ace.dto.studentGrade.StudentGradeDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IReservationService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReservationDto>> getStudentsForTask(@PathVariable("id") int id) {

        List<ReservationDto> reservations = reservationService.getAllReservationsForUser(id);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public ResponseEntity<ReservationDto> saveReservation(@Valid @RequestBody ESReservationDto esReservationDto,
                                                          BindingResult bindingResult, @PathVariable("userId") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        ReservationDto reservationDto = reservationService.save(esReservationDto, id);

        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ReservationDto> deleteProfessor(@PathVariable("id") int id) {
        ReservationDto deleted = reservationService.delete(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}

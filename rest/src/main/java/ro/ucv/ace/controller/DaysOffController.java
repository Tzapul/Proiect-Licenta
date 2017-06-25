package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.dto.reservation.ReservationDto;
import ro.ucv.ace.dto.studentGrade.StudentGradeDto;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.dto.user.UserLoginDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IDaysOffService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@RestController
@RequestMapping(value = "/daysOff")
public class DaysOffController {

    @Autowired
    private IDaysOffService daysOffService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<DaysOffDto>> getAllDaysOff() {

        List<DaysOffDto> daysOff = daysOffService.getAllDaysOff();

        return new ResponseEntity<>(daysOff, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<DaysOffDto> postLogin(@Valid @RequestBody DaysOffDto daysOffDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            throw new EntityBindingException(bindResult.getFieldErrors());
        }

        DaysOffDto userDto = daysOffService.save(daysOffDto);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DaysOffDto> deleteDaysOff(@PathVariable("id") int id) {
        DaysOffDto deleted = daysOffService.delete(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}

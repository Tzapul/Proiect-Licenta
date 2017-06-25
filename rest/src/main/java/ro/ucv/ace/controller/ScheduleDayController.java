package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.dto.scheduleDay.EScheduleDayDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.dto.task.ETaskDto;
import ro.ucv.ace.dto.task.TaskDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.model.ScheduleDay;
import ro.ucv.ace.service.IScheduleDayService;
import ro.ucv.ace.service.impl.ScheduleDayService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@RestController
@RequestMapping(value = "/scheduleDays")
public class ScheduleDayController {

    @Autowired
    private IScheduleDayService scheduleDayService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleDayDto>> getAllDaysOff() {

        List<ScheduleDayDto> daysOff = scheduleDayService.getAllScheduleDays();

        return new ResponseEntity<>(daysOff, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ScheduleDayDto> editTask(@Valid @RequestBody EScheduleDayDto scheduleDayDto, BindingResult bindingResult,
                                                   @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        ScheduleDayDto edited = scheduleDayService.update(scheduleDayDto, id);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }
}

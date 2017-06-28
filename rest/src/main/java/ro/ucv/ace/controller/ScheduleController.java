package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.service.IScheduleDayService;
import ro.ucv.ace.service.IScheduleService;

import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private IScheduleDayService scheduleDayService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleDayDto>> getAllDaysOff() {

        List<ScheduleDayDto> daysOff = scheduleDayService.getAllScheduleDays();

        return new ResponseEntity<>(daysOff, HttpStatus.OK);
    }
}

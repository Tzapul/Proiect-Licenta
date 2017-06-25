package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.dto.TableDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.service.IScheduleDayService;
import ro.ucv.ace.service.ITablesService;

import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@RestController
@RequestMapping(value = "/tables")
public class TablesController {

    @Autowired
    private ITablesService tablesService;

    @RequestMapping(value = "/getAllForToday", method = RequestMethod.GET)
    public ResponseEntity<List<TableDto>> getAllDaysOff() {

        List<TableDto> tableDtos = tablesService.getAllTablesForToday();

        return new ResponseEntity<>(tableDtos, HttpStatus.OK);
    }
}

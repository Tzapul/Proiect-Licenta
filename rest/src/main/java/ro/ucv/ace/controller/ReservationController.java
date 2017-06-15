package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.service.IReservationService;

/**
 * Created by tzapt on 6/15/2017.
 */
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<String> pingAndText() {
        return new ResponseEntity<>("This is a test message", HttpStatus.OK);
    }
}

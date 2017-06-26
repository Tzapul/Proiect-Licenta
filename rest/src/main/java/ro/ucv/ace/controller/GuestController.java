package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.dto.guest.GuestDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IGuestService;

/**
 * Created by itsix on 26/06/2017.
 */
@RestController
@RequestMapping(value = "/")
public class GuestController {

    @Autowired
    private IGuestService guestService;

    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public ResponseEntity<GuestDto> postTest() {

        GuestDto guestDto = guestService.register();

        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
    }
}

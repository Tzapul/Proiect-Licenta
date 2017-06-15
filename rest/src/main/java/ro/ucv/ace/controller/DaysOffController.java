package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.service.IDaysOffService;

/**
 * Created by tzapt on 6/15/2017.
 */
@RestController
@RequestMapping(value = "/daysOff")
public class DaysOffController {

    @Autowired
    private IDaysOffService daysOffService;
}

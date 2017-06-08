package ro.ucv.ace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a test controller.
 *
 * @author Georgian Vladutu
 */
@RestController
@RequestMapping(value = "/")
public class TestController {

    /**
     * Returns a ping with 200 OK status.
     *
     * @return 200 OK status
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<String> pingAndText() {
        return new ResponseEntity<>("This is a test message", HttpStatus.OK);
    }

    @RequestMapping(value = "/post-test", method = RequestMethod.POST)
    public ResponseEntity<String> postTest(@RequestBody String json) {
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
}

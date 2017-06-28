package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.user.EUserDto;
import ro.ucv.ace.dto.user.SUserDto;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IUserService;

import javax.validation.Valid;

/**
 * Created by itsix on 26/06/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateProfessor(@Valid @RequestBody EUserDto userDto, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        UserDto edited = userService.edit(id, userDto);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }
}

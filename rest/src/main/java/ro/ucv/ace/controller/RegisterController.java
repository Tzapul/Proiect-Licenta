package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.dto.client.ClientDto;
import ro.ucv.ace.dto.client.ESClientDto;
import ro.ucv.ace.dto.user.ESUserDto;
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.dto.user.UserLoginDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.User;
import ro.ucv.ace.service.IClientService;
import ro.ucv.ace.service.IUserService;

import javax.validation.Valid;

/**
 * Created by tzapt on 6/20/2017.
 */
@RestController
@RequestMapping(value = "/")
public class RegisterController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDto> postRegister(@Valid @RequestBody ESUserDto esUserDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            throw new EntityBindingException(bindResult.getFieldErrors());
        }

        UserDto user = userService.save(esUserDto);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

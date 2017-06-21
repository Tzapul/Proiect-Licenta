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
import ro.ucv.ace.dto.user.UserDto;
import ro.ucv.ace.dto.user.UserLoginDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.service.IClientService;

import javax.validation.Valid;

/**
 * Created by tzapt on 6/20/2017.
 */
@RestController
@RequestMapping(value = "/")
public class RegisterController {

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ClientDto> postRegister(@Valid @RequestBody ESClientDto clientDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            throw new EntityBindingException(bindResult.getFieldErrors());
        }

        ClientDto client = clientService.save(clientDto);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}

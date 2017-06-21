package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IClientBuilder;
import ro.ucv.ace.dto.client.ESClientDto;
import ro.ucv.ace.dto.professor.ESProfessorDto;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.Professor;

/**
 * Created by tzapt on 6/20/2017.
 */
@Component
public class ClientBuilder implements IClientBuilder {

    @Override
    public Client build(ESClientDto clientDto) {
        return new Client(clientDto.getFirstName(), clientDto.getLastName(), clientDto.getPhoneNumber(),
                clientDto.getEmail(), clientDto.getUsername(), clientDto.getPassword());
    }
}

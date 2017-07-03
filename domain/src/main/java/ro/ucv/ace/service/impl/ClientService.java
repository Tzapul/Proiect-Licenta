package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IClientBuilder;
import ro.ucv.ace.dto.client.ClientDto;
import ro.ucv.ace.dto.client.ESClientDto;
import ro.ucv.ace.exception.InvalidEmailFormat;
import ro.ucv.ace.exception.UsernameAlreadyUsed;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.repository.IClientRepository;
import ro.ucv.ace.repository.IUserRepository;
import ro.ucv.ace.service.IClientService;
import ro.ucv.ace.validator.EmailValidator;
import ro.ucv.ace.visitor.ClientVisitor;

/**
 * Created by tzapt on 6/20/2017.
 */
@Service("clientService")
@Transactional(rollbackFor = Exception.class)
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IClientBuilder clientBuilder;

    @Autowired
    private ClientVisitor clientVisitor;

    @Override
    public ClientDto save(ESClientDto clientDto) {

        String username = clientDto.getUsername();

        if (!EmailValidator.validate(clientDto.getEmail())) {
            throw new InvalidEmailFormat("The email is not in a valid format!");
        }

        while (userRepository.usernameExists(username)) {
            throw new UsernameAlreadyUsed("The username " + username + " already exists!");
        }

        Client client = clientRepository.save(clientBuilder.build(clientDto));

        client.accept(clientVisitor);

        return clientVisitor.getClientDto();
    }
}

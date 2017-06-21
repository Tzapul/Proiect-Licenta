package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.client.ClientDto;
import ro.ucv.ace.dto.professor.ProfessorDto;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.Professor;

/**
 * Created by tzapt on 6/20/2017.
 */
@Component
public class ClientVisitor {

    private ClientDto clientDto;

    public void visit(Client client) {
        clientDto = new ClientDto(client.getId(), client.getUsername(), client.getPassword(),
                client.getPersonDetails().getFirstName(), client.getPersonDetails().getLastName(), client.getAccount().getEmail(),
                client.getPersonDetails().getPhoneNumber());
    }

    public ClientDto getClientDto() {
        return clientDto;
    }
}

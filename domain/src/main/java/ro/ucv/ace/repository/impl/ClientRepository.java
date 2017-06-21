package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.DaysOff;
import ro.ucv.ace.repository.IClientRepository;
import ro.ucv.ace.repository.IJpaRepository;

import java.util.List;

/**
 * Created by tzapt on 6/20/2017.
 */
@Repository("clientRepository")
public class ClientRepository implements IClientRepository {

    @Autowired
    private IJpaRepository<Client, Integer> innerClientRepository;

    @Override
    public Client save(Client client) {
        return innerClientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return innerClientRepository.findAll();
    }

    @Override
    public Client delete(int id) {
        return innerClientRepository.delete(id);
    }

    @Override
    public Client findOne(int id) { return innerClientRepository.findOne(id); }
}

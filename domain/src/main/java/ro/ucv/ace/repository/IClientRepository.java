package ro.ucv.ace.repository;

import ro.ucv.ace.model.Client;

import java.util.List;

/**
 * Created by tzapt on 6/20/2017.
 */
public interface IClientRepository {

    Client save(Client client);

    List<Client> findAll();

    Client delete(int id);

    Client findOne(int id);
}

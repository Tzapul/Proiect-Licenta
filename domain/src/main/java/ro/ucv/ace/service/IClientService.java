package ro.ucv.ace.service;

import ro.ucv.ace.dto.client.ClientDto;
import ro.ucv.ace.dto.client.ESClientDto;

/**
 * Created by tzapt on 6/20/2017.
 */
public interface IClientService {
    ClientDto save(ESClientDto clientDto);
}

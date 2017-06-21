package ro.ucv.ace.builder;

import ro.ucv.ace.dto.client.ESClientDto;
import ro.ucv.ace.model.Client;

/**
 * Created by tzapt on 6/20/2017.
 */
public interface IClientBuilder {
    Client build(ESClientDto clientDto);
}

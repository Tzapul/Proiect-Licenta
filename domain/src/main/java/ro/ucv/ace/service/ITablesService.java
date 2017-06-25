package ro.ucv.ace.service;

import ro.ucv.ace.dto.TableDto;

import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface ITablesService {
    List<TableDto> getAllTablesForToday();
}

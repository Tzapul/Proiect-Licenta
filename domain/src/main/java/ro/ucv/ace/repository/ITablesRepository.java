package ro.ucv.ace.repository;

import ro.ucv.ace.dto.TableDto;
import ro.ucv.ace.model.Tables;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface ITablesRepository {
    Tables save(Tables client);

    List<Tables> findAll();

    Tables delete(int id);

    Tables findOne(int id);

    List<Tables> findAllFreeTablesForDate(LocalDate date);

    List<Tables> findAllFreeTablesForDateAndHour(LocalDate date, int hour);
}

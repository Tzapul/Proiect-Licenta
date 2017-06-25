package ro.ucv.ace.repository.impl;

import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Client;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.model.Tables;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.ITablesRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@Repository("tablesRepository")
public class TablesRepository implements ITablesRepository {

    @Autowired
    private IJpaRepository<Tables, Integer> innerTablesRepository;

    @Override
    public Tables save(Tables tables) { return innerTablesRepository.save(tables); }

    @Override
    public List<Tables> findAll() {
        return innerTablesRepository.findAll();
    }

    @Override
    public Tables delete(int id) {
        return innerTablesRepository.delete(id);
    }

    @Override
    public Tables findOne(int id) { return innerTablesRepository.findOne(id); }

    @Override
    public List<Tables> findAllFreeTablesForDate(LocalDate date) {
        List<Tables> tables = new ArrayList<>();
        List<Tables> allTables = innerTablesRepository.findAll();

        for(Tables table: allTables) {
            for (Reservation reservation: table.getReservations()) {
                if(reservation.getDate().equals(date)) {
                    tables.add(table);
                }
            }

            if(allTables.size() == tables.size()) {
                break;
            }
        }

        allTables.removeAll(tables);

        return allTables;
    }

}

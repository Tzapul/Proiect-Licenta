package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.dto.TableDto;
import ro.ucv.ace.model.Tables;
import ro.ucv.ace.repository.IReservationRepository;
import ro.ucv.ace.repository.ITablesRepository;
import ro.ucv.ace.service.ITablesService;
import ro.ucv.ace.visitor.TableVisitor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@Service("tablesService")
@Transactional(rollbackFor = Exception.class)
public class TablesService implements ITablesService {

    @Autowired
    private ITablesRepository tablesRepository;

    @Autowired
    private TableVisitor tableVisitor;
    @Override
    public List<TableDto> getAllTablesForToday() {
        List<Tables> tables = tablesRepository.findAllFreeTablesForDate(LocalDate.now());
        List<TableDto> tableDtos = new ArrayList<>();

        tables.forEach(d -> {
            d.accept(tableVisitor);
            tableDtos.add(tableVisitor.getTableDto());
        });

        return tableDtos;
    }
}

package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.TableDto;
import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.model.DaysOff;
import ro.ucv.ace.model.Tables;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class TableVisitor {

    private TableDto tableDto;

    public void visit(Tables table) {
        tableDto = new TableDto(table.getName(), table.getNoOfPeople());
    }

    public TableDto getTableDto() {
        return tableDto;
    }
}

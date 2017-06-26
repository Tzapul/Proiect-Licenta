package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.model.DaysOff;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class DaysOffVisitor {

    private DaysOffDto daysOffDto;

    public void visit(DaysOff daysOff) {
        daysOffDto = new DaysOffDto(daysOff.getId(), daysOff.getDate().toString());
    }

    public DaysOffDto getDaysOffDto() {
        return daysOffDto;
    }
}

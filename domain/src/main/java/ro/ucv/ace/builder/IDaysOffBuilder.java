package ro.ucv.ace.builder;

import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.model.DaysOff;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IDaysOffBuilder {
    DaysOff build(DaysOffDto daysOffDto);
}

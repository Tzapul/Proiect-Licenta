package ro.ucv.ace.builder;

import ro.ucv.ace.dto.daysOff.ESDaysOffDto;
import ro.ucv.ace.model.DaysOff;

/**
 * Created by tzapt on 6/25/2017.
 */
public interface IDaysOffBuilder {
    DaysOff build(ESDaysOffDto daysOffDto);
}

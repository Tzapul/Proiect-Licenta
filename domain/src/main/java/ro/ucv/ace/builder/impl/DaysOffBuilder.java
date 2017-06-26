package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IDaysOffBuilder;
import ro.ucv.ace.converter.StringConverter;
import ro.ucv.ace.dto.daysOff.ESDaysOffDto;
import ro.ucv.ace.model.DaysOff;

/**
 * Created by tzapt on 6/25/2017.
 */
@Component
public class DaysOffBuilder implements IDaysOffBuilder {

    @Override
    public DaysOff build(ESDaysOffDto daysOffDto) {
        return new DaysOff(StringConverter.toDate(daysOffDto.getDate()));
    }
}

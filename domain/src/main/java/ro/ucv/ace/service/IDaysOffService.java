package ro.ucv.ace.service;

import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.dto.daysOff.ESDaysOffDto;

import java.io.IOException;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
public interface IDaysOffService {
    List<DaysOffDto> getAllDaysOff();

    DaysOffDto delete(int id);

    DaysOffDto save(ESDaysOffDto daysOffDto);
}

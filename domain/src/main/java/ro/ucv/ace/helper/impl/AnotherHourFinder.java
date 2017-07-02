package ro.ucv.ace.helper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ucv.ace.converter.StringConverter;
import ro.ucv.ace.helper.IAnotherHourFinder;
import ro.ucv.ace.model.ScheduleDay;
import ro.ucv.ace.model.Tables;
import ro.ucv.ace.repository.IScheduleDayRepository;
import ro.ucv.ace.repository.ITablesRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by tzapt on 7/2/2017.
 */
@Component
public class AnotherHourFinder implements IAnotherHourFinder {

    @Autowired
    private ITablesRepository tablesRepository;

    @Autowired
    private IScheduleDayRepository scheduleDayRepository;

    @Override
    public int findHourGreaterThan(int hour, int people, String date) {
        Date myDate = StringConverter.toDate(date);
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(myDate);
        ScheduleDay scheduleDay = scheduleDayRepository.findByDay(dayOfWeek.toUpperCase());

        int upperBound = scheduleDay.getEnd();
        if(hour > upperBound - 2) {
            return -1;
        }

        while(hour <= upperBound - 2) {
            hour++;
            List<Tables> tables = tablesRepository.findAllFreeTablesForDateAndHour(StringConverter.toLocalDate(date), hour);

            if(checkIfTablesAreOkay(tables, people)) {
                return hour;
            }
        }

        return -1;
    }

    @Override
    public int findHourLesserThan(int hour, int people, String date) {
        Date myDate = StringConverter.toDate(date);
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(myDate);
        ScheduleDay scheduleDay = scheduleDayRepository.findByDay(dayOfWeek.toUpperCase());

        int lowerBound = scheduleDay.getStart();
        if(hour < lowerBound) {
            return -1;
        }

        while(hour >= lowerBound) {
            hour--;
            List<Tables> tables = tablesRepository.findAllFreeTablesForDateAndHour(StringConverter.toLocalDate(date), hour);

            if(checkIfTablesAreOkay(tables, people)) {
                return hour;
            }
        }

        return -1;
    }

    private boolean checkIfTablesAreOkay(List<Tables> tables, int people) {
        int maxPeople = 0;

        if(tables.size() != 0) {
            for (Tables table:  tables) {
                maxPeople += table.getNoOfPeople();
            }

            if(people >= maxPeople) {
                return true;
            }
        }

        return false;
    }
}

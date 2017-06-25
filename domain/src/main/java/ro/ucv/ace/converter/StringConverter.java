package ro.ucv.ace.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by tzapt on 6/25/2017.
 */
public class StringConverter {

    public static LocalDate toLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    public static Date toDate(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date dateToReturn = null;
        try {
            dateToReturn = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateToReturn;
    }
}

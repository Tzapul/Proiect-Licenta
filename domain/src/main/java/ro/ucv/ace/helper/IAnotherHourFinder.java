package ro.ucv.ace.helper;

/**
 * Created by tzapt on 7/2/2017.
 */
public interface IAnotherHourFinder {
    int findHourGreaterThan(int hour, int people, String date);

    int findHourLesserThan(int hour, int people, String date);
}

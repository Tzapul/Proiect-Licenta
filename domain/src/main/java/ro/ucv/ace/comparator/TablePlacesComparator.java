package ro.ucv.ace.comparator;

import org.springframework.stereotype.Component;
import ro.ucv.ace.model.Tables;

import java.util.Comparator;

/**
 * Created by tzapt on 7/2/2017.
 */
@Component
public class TablePlacesComparator implements Comparator<Tables>{

    @Override
    public int compare(Tables o1, Tables o2) {
        return compare(o1.getNoOfPeople(), o2.getNoOfPeople());
    }

    private static int compare(int a, int b) {
        return a < b ? -1
                : a > b ? 1
                : 0;
    }
}

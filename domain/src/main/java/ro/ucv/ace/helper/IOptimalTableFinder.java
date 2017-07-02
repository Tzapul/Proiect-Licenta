package ro.ucv.ace.helper;

import ro.ucv.ace.model.Tables;

import java.util.List;

/**
 * Created by tzapt on 7/2/2017.
 */
public interface IOptimalTableFinder {
    List<Tables> getOptimalTables(int people, List<Tables> freeTables);
}

package ro.ucv.ace.helper.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.helper.IOptimalTableFinder;
import ro.ucv.ace.model.Tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tzapt on 7/2/2017.
 */
@Component
public class OptimalTableFinder implements IOptimalTableFinder {

    private List<Tables> freeTables;

    @Override
    public List<Tables> getOptimalTables(int people, List<Tables> freeTables) {
        this.freeTables = freeTables;
        Tables table = searchForTableWithPeople(people);
        List<Tables> tablesToBeGiven;

        if (thereIsNoTableFound(table)) {
            tablesToBeGiven = findPlaces(people);
            int betterTableIndex = searchIndexLessThan(people);

            if(!validSolution(tablesToBeGiven, people) && betterTableIndex == tablesToBeGiven.size()) {
                return null;
            }

            if (betterTableIndex != freeTables.size()) {
                if (checkIfThereIsABetterSolution(tablesToBeGiven, betterTableIndex)) {
                    return Collections.singletonList(freeTables.get(betterTableIndex));
                }
            }

            return tablesToBeGiven;
        }

        return Collections.singletonList(table);
    }

    private boolean validSolution(List<Tables> tablesToBeGiven, int people) {
        int peopleSum = 0;

        for (Tables table : tablesToBeGiven) {
            peopleSum += table.getNoOfPeople();
        }

        return peopleSum > people;
    }

    private boolean checkIfThereIsABetterSolution(List<Tables> tables, int index) {
        int peopleSum = 0;

        for (Tables table : tables) {
            peopleSum += table.getNoOfPeople();
        }

        if (freeTables.get(index).getNoOfPeople() < peopleSum) {
            return true;
        }

        return false;

    }

    private boolean thereIsNoTableFound(Tables table) {
        return table == null;
    }

    private Tables searchForTableWithPeople(int people) {
        for (Tables table : freeTables) {
            if (table.getNoOfPeople() == people) {
                return table;
            }
        }

        return null;
    }

    private List<Tables> findPlaces(int people) {
        if (people == 0) {
            return new ArrayList<>();
        }

        int idx = searchIndexLessThan(people);

        List<Tables> givenTables = new ArrayList<>();

        if (idx == 0) {
            givenTables.add(freeTables.get(0));
            return givenTables;
        }

        int peopleLeft = people - freeTables.get(idx).getNoOfPeople();

        givenTables.add(freeTables.get(idx));
        givenTables.addAll(findPlaces(peopleLeft));

        return givenTables;
    }

    private int searchIndexLessThan(int people) {
        for (int i = freeTables.size() - 1; i >= 0; i--) {
            if (freeTables.get(i).getNoOfPeople() <= people) {
                return i;
            }
        }
        return 0;
    }
}

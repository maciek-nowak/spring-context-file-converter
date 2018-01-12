package com.codecool.view;

import java.util.ArrayList;
import java.util.List;

public interface OutputFormatter {

    void printToConsole(List<String> data);

    default List<String[]> splitDataRows(List<String> data) {

        List<String[]> splittedRows = new ArrayList<>();

        for (String row : data) {
            String[] splittedRow = row.split(",", -1);
            splittedRows.add(splittedRow);
        }

        return splittedRows;
    }
}

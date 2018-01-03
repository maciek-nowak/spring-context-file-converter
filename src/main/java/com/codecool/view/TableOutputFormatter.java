package com.codecool.view;

import java.util.ArrayList;
import java.util.List;

public class TableOutputFormatter implements OutputFormatter{
    @Override
    public void printToConsole(List<String> data) {
        List<String[]> splittedRows = splitDataRows(data);
        String table = buildTable(splittedRows);
        System.out.println(table);

    }

    private String buildTable(List<String[]> splittedRows) {
        List<Integer> columnsWidth = calculateColumnsWidth(splittedRows);
        Integer tableWidth  = columnsWidth.stream().mapToInt(Integer::intValue).sum();
        StringBuilder table = new StringBuilder();

        for (String[] row : splittedRows) {
            String xmlRow = buildTableRow(row, columnsWidth);
            table.append(xmlRow);
        }

        return table.toString();
    }

    private String buildTableRow(String[] row, List<Integer> columnsWidth) {
        StringBuilder tableRow = new StringBuilder();

        for (int i = 0; i < row.length; i++) {
            String value = row[i];
            tableRow.append(String.format("|%" + columnsWidth.get(i) + "s", value));
        }

        tableRow.append("|\n");
        return tableRow.toString();
    }

    private List<Integer> calculateColumnsWidth(List<String[]> splittedRows){
        List<Integer> columnWidths = new ArrayList<>();
        Integer gapWidth = 3;

        for (int columnIndex = 0; columnIndex < splittedRows.get(0).length; columnIndex++) {
            Integer columnWidth = calculateColumnWidth(splittedRows, columnIndex);
            columnWidths.add(columnWidth + gapWidth);
        }

        return columnWidths;
    }

    private Integer calculateColumnWidth(List<String[]> splittedRows, int columnIndex) {
        Integer columnWidth = 0;

        for (String[] row : splittedRows) {

            if (row[columnIndex].length() > columnWidth) {
                columnWidth = row[columnIndex].length();
            }

        }

        return columnWidth;
    }

}

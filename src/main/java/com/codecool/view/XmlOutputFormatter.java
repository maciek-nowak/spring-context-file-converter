package com.codecool.view;

import java.util.List;

public class XmlOutputFormatter implements OutputFormatter{
    @Override
    public void printToConsole(List<String> data) {
        List<String[]> splittedRows = splitDataRows(data);
        String xmlRepresentation = buildXml(splittedRows);
        System.out.println(xmlRepresentation);

    }

    /*private String buildXml(List<String[]> splittedRows) {
        String xmlRepresentation = "<rows>\n";
        String[] columnNames = splittedRows.get(0);
        splittedRows.remove(0);

        for (String[] row : splittedRows) {
            String xmlRow = buildxmlRow(columnNames, row);
            xmlRepresentation += xmlRow;
        }

        xmlRepresentation += "</rows>";
        return xmlRepresentation;
    }

    private String buildxmlRow(String[] columnNames, String[] row) {
        String xmlRow = "    <row>\n";

        for (int i = 0; i < columnNames.length; i++) {
            String key = columnNames[i];
            String value = row[i];
            xmlRow += String.format("        <%s>%s</%s>\n", key, value, key);
        }

        xmlRow += "    </row>\n";
        return xmlRow;
    }*/

    private String buildXml(List<String[]> splittedRows) {
        StringBuilder xmlRepresentation = new StringBuilder("<rows>\n");
        String[] columnNames = splittedRows.get(0);
        splittedRows.remove(0);

        for (String[] row : splittedRows) {
            String xmlRow = buildxmlRow(columnNames, row);
            xmlRepresentation.append(xmlRow);
        }

        xmlRepresentation.append("</rows>");
        return xmlRepresentation.toString();
    }

    private String buildxmlRow(String[] columnNames, String[] row) {
        StringBuilder xmlRow = new StringBuilder("    <row>\n");

        for (int i = 0; i < columnNames.length; i++) {
            String key = columnNames[i];
            String value = row[i];
            xmlRow.append(String.format("        <%s>%s</%s>\n", key, value, key));
        }

        xmlRow.append("    </row>\n");
        return xmlRow.toString();
    }

}

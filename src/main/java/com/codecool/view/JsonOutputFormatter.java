package com.codecool.view;

import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;

public class JsonOutputFormatter implements OutputFormatter{

    @Override
    public void printToConsole(List<String> data) {
        List<String[]> splittedRows = splitDataRows(data);
        JSONArray jsonArray = buildArray(splittedRows);
        System.out.println(jsonArray);

    }

    private JSONArray buildArray(List<String[]> splittedRows) {
        JSONArray jsonArray = new JSONArray();
        String[] columnNames = splittedRows.get(0);
        splittedRows.remove(0);

        for (String[] row : splittedRows) {
            JSONObject jsonObject = buildJson(columnNames, row);
            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }

    private JSONObject buildJson(String[] columnNames, String[] row) {
        JSONObject jsonObject = new JSONObject();

        for (int i = 0; i < columnNames.length; i++) {
            String key = columnNames[i];
            String value = row[i];
            jsonObject.put(key, value);
        }

        return jsonObject;

    }

}

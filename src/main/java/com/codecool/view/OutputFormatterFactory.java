package com.codecool.view;

import com.codecool.enums.OutputFormats;

public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormats outputFormat){
        OutputFormatter outputFormatter = null;

        switch (outputFormat) {
            case TABLE:
                outputFormatter = new TableOutputFormatter();
                break;
            case XML:
                outputFormatter = new XmlOutputFormatter();
                break;
            case JSON:
                outputFormatter = new JsonOutputFormatter();
                break;
        }
        return outputFormatter;
    }
}

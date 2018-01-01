package com.codecool.view;

import com.codecool.enums.OutputFormats;

public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormats outputFormat){
        return new JsonOutputFormatter();
    }
}

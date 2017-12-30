package com.codecool;

import com.codecool.enums.OutputFormats;

public class SimpleCsvConverter {

    private FileReader fileReader;

    public SimpleCsvConverter(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void convert(String file, OutputFormats outputFormat) {
        System.out.println("I convert CSV to output format:" + outputFormat);
    }

    public void convert(String file) {
        OutputFormats outputFormat = OutputFormats.TABLE;
        convert(file, outputFormat);
    }
}

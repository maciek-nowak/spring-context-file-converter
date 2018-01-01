package com.codecool;

import com.codecool.enums.OutputFormats;
import com.codecool.view.OutputFormatter;
import com.codecool.view.OutputFormatterFactory;

import java.io.File;
import java.util.List;

public class SimpleCsvConverter {

    private FileReader fileReader;
    private OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(File file, OutputFormats outputFormat) {
        System.out.println("I convert CSV to output format:" + outputFormat);
        List<String> data = this.fileReader.read(file);
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
    }

    public void convert(File file) {
        OutputFormats outputFormat = OutputFormats.TABLE;
        convert(file, outputFormat);
    }
}

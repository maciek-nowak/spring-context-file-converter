package com.codecool;

import com.codecool.enums.OutputFormats;
import com.codecool.service.FileReader;
import com.codecool.service.SimpleCsvConverter;
import com.codecool.view.OutputFormatterFactory;

import java.io.File;

public class ConverterApplication {

    public static void main(String[] args) {
        Integer argumentsCount = args.length;
        FileReader fileReader = new FileReader();
        OutputFormatterFactory outputFormatterFactory = new OutputFormatterFactory();
        SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(fileReader, outputFormatterFactory);

        if (argumentsCount == 0) {
            System.out.println("No input file defined");
            System.out.println("Proper command format: java ConvertApplication xml test.csv");

        } else if (argumentsCount == 1 && new File(args[0]).isFile()){
            simpleCsvConverter.convert(new File(args[0]));

        } else if (argumentsCount > 1 && new File(args[1]).isFile() && OutputFormats.contains(args[0])) {
            simpleCsvConverter.convert(new File(args[1]), OutputFormats.getOutputFormat(args[0]));

        } else {
            System.out.println("No proper arguments found! Try again!");
            System.out.println("Proper command format: java ConvertApplication xml test.csv");
        }
    }
}

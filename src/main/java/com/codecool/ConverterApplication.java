package com.codecool;

import com.codecool.enums.OutputFormats;

import java.io.File;

public class ConverterApplication {

    public static void main(String[] args) {
        Integer argumentsCount = args.length;
        SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter();

        if (argumentsCount == 0) {
            System.out.println("No input file defined");

        } else if (argumentsCount == 1 && new File(args[0]).isFile()){
            System.out.println("File has been found!");
            simpleCsvConverter.convert(args[0]);

        } else if (argumentsCount > 1 && new File(args[1]).isFile() && OutputFormats.contains(args[0])) {
            System.out.println("Proper format and file have been found!");
            simpleCsvConverter.convert(args[1], OutputFormats.getOutputFormat(args[0]));

        } else {
            System.out.println("No proper arguments found! Try again!");
        }
    }
}

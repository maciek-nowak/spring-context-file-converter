package com.codecool;

import com.codecool.enums.OutputFormats;

import java.io.File;

public class ConverterApplication {

    public static void main(String[] args) {
        Integer argumentsCount = args.length;

        if (argumentsCount == 0) {
            System.out.println("No input file defined");

        } else if (argumentsCount == 1 && new File(args[0]).isFile()){
            System.out.println("File has been found!");

        } else if (argumentsCount > 1 && new File(args[1]).isFile() && OutputFormats.contains(args[0])) {
            System.out.println("Proper format and file have been found!");
        } else {
            System.out.println();
        }
    }
}

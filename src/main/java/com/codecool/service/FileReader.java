package com.codecool.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> read(File file) {
        List<String> fileContent = new ArrayList<>();

        try (Scanner fileScan = new Scanner(file)) {

            while(fileScan.hasNextLine()) {
                fileContent.add(fileScan.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("File has been read");
        return fileContent;
    }
}

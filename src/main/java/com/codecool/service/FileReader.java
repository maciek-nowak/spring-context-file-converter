package com.codecool.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
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

        return fileContent;
    }
}

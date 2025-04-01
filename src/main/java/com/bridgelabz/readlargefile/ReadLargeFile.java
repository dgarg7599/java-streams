package com.bridgelabz.readlargefile;

import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        String fileName = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\readlargefile\\input.txt";

        // Read file line by line efficiently
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("streams")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
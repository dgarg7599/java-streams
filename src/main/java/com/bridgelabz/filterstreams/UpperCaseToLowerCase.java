package com.bridgelabz.filterstreams;

import java.io.*;

public class UpperCaseToLowerCase {
    public static void main(String[] args) {
        String inputFile = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\filterstreams\\input.txt";
        String outputFile = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\filterstreams\\output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }

            System.out.println("File converted successfully.");

        }
        catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
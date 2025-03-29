package com.bridgelabz.filehandling;

import java.io.*;

public class ReadAndWriteFile {

    public static void main(String[] args) {
        // Define source and destination file paths
        String sourceFile = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\filehandling\\source.txt";
        String destinationFile = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\filehandling\\destination.txt";

        // Call the method to copy file content
        copyFile(sourceFile, destinationFile);
    }


    public static void copyFile(String source, String destination) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Open the source file for reading
            File inputFile = new File(source);
            if (!inputFile.exists()) {
                System.out.println("Error: Source file does not exist.");
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(destination); // Destination file is created if not exists

            // Read and write the file content
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully from " + source + " to " + destination);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
package com.bridgelabz.bytearraystream;

import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\bytearraystream\\input.jpg";
        String outputImagePath = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\bytearraystream\\output.jpg";

        try {
            // Reading the image file into byte array
            byte[] imageBytes = readImageFile(inputImagePath);

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // Reading from ByteArrayInputStream and writing to ByteArrayOutputStream
            int byteRead;
            while ((byteRead = bais.read()) != -1) {
                baos.write(byteRead);
            }

            // Retrieving image data from ByteArrayOutputStream as byte array
            byte[] outputImageBytes = baos.toByteArray();

            // Writing the byte array to a new image file
            writeImageFile(outputImagePath, outputImageBytes);

            // Verifying if the files are identical
            boolean identical = Arrays.equals(imageBytes, outputImageBytes);
            System.out.print("Are the Image files identical? ");
            System.out.print((identical) ? "Yes" : "No");

        }
        catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
        }
    }

    // Method to read image file
    private static byte[] readImageFile(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] imageBytes = new byte[(int) file.length()];

        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(imageBytes);
        }
        return imageBytes;
    }

    // Method to write image file
    private static void writeImageFile(String filePath, byte[] imageBytes) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageBytes);
        }
    }
}
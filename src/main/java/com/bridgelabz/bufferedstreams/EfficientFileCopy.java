package com.bridgelabz.bufferedstreams;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\bufferedstreams\\source.txt";
        String destinationFile = "D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\bufferedstreams\\destination.txt";

        System.out.println("Copying using Buffered Streams...");
        long bufferedTime = copyFileBuffered(sourceFile, destinationFile);
        System.out.println("Buffered Copy Time: " + bufferedTime + " nanoseconds\n");

        System.out.println("Copying using Unbuffered Streams...");
        long unbufferedTime = copyFileUnbuffered(sourceFile, destinationFile);
        System.out.println("Unbuffered Copy Time: " + unbufferedTime + " nanoseconds");
    }

    public static long copyFileBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    public static long copyFileUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}

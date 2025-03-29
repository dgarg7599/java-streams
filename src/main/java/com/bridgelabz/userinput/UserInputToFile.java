package com.bridgelabz.userinput;

import java.io.*;
public class UserInputToFile {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter("D:\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\userinput\\user_data.txt")){

            System.out.println("Enter your name: ");
            String name = reader.readLine();

            System.out.println("Enter your age: ");
            String age = reader.readLine();

            System.out.println("Enter your favourite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favourite Programming language: " + language + "\n");

            System.out.println("User information has been saved to the file successfully.");
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
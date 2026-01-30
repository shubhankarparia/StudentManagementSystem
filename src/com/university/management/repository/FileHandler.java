package com.university.management.repository;

import com.university.management.model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to handle File I/O operations.
 * This ensures data persistence (saving data to a physical file).
 */
public class FileHandler {
    private static final String FILE_PATH = "data/students.txt";

    /**
     * Saves the entire list of students to the text file.
     */
    public static void saveToFile(List<Student> students) {
        // Ensure the 'data' directory exists
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                // Save data in a CSV-like format: ID,Name,Email,Course
                writer.write(s.getId() + "," + s.getName() + "," + s.getEmail() + "," + s.getCourse());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    /**
     * Loads students from the text file into the program's memory.
     */
    public static List<Student> loadFromFile() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return students; // Return empty list if file doesn't exist yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String email = data[2];
                    String course = data[3];
                    students.add(new Student(id, name, email, course));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }
        return students;
    }
}
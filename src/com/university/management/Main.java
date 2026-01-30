package com.university.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Project: Student Management System
 * Goal: Manage student records via Console
 * Features: CRUD operations (Create, Read, Update, Delete)
 */
public class Main {
    // Shared list to act as a temporary database
    private static List<String> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=== WELCOME TO ZYPHRONIX STUDENT MANAGEMENT SYSTEM ===");

        while (running) {
            printMenu();
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting System... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again (1-5).");
            }
        }
        scanner.close();
    }

    // --- HELPER METHODS (Business Logic) ---

    private static void printMenu() {
        System.out.println("\n----------------------------");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Record");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        studentList.add(name);
        System.out.println("Success: Student '" + name + "' added!");
    }

    private static void viewStudents() {
        System.out.println("\n--- Current Student Records ---");
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((i + 1) + ". " + studentList.get(i));
            }
        }
    }

    private static void updateStudent() {
        viewStudents();
        if (studentList.isEmpty()) return;

        System.out.print("Enter index number to update: ");
        int index = getIntegerInput() - 1;

        if (index >= 0 && index < studentList.size()) {
            System.out.print("Enter New Name: ");
            String newName = scanner.nextLine();
            studentList.set(index, newName);
            System.out.println("Success: Record updated!");
        } else {
            System.out.println("Error: Invalid index.");
        }
    }

    private static void deleteStudent() {
        viewStudents();
        if (studentList.isEmpty()) return;

        System.out.print("Enter index number to delete: ");
        int index = getIntegerInput() - 1;

        if (index >= 0 && index < studentList.size()) {
            String removed = studentList.remove(index);
            System.out.println("Success: Student '" + removed + "' removed.");
        } else {
            System.out.println("Error: Invalid index.");
        }
    }

    // Utility to prevent program crash on non-integer input
    private static int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }
}
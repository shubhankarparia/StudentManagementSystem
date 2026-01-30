package com.university.management.ui;

import java.util.Scanner;

/**
 * UI Class responsible for the Console Interface.
 * Separates presentation logic from business logic.
 */
public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prints the main application header.
     */
    public static void printHeader() {
        System.out.println("==============================================");
        System.out.println("   ZYPHRONIX STUDENT MANAGEMENT SYSTEM       ");
        System.out.println("==============================================");
    }

    /**
     * Displays the menu options and returns the user's choice.
     */
    public static int displayMenuAndGetChoice() {
        System.out.println("\n[MAIN MENU]");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Record");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Exit Application");
        System.out.print("\nSelect an option (1-5): ");

        return getSafeInt();
    }

    /**
     * Reusable method to get a String input from the user.
     */
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Reusable method to get an Integer input with validation.
     */
    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        return getSafeInt();
    }

    /**
     * Prevents the program from crashing if a user enters non-numeric text.
     */
    private static int getSafeInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            System.out.print("Try again: ");
            scanner.next(); // Clear the invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character
        return value;
    }

    public static void showMessage(String message) {
        System.out.println("\n>>> " + message);
    }

    public static void showDivider() {
        System.out.println("----------------------------------------------");
    }
}
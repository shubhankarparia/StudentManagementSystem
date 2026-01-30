package com.university.management.service;

import com.university.management.model.Student;
import java.util.List;

/**
 * Service Interface defining the contract for Student Management operations.
 * This demonstrates Abstraction (OOP Concept).
 */
public interface Management {
    
    /**
     * Adds a new student record to the system.
     * @param student The student object to be added.
     */
    void addStudent(Student student);

    /**
     * Retrieves all student records currently in the system.
     * @return A list of all students.
     */
    List<Student> getAllStudents();

    /**
     * Updates an existing student record by their unique ID.
     * @param id The ID of the student to update.
     * @param updatedStudent The student object containing new details.
     * @return true if updated successfully, false if ID not found.
     */
    boolean updateStudent(int id, Student updatedStudent);

    /**
     * Removes a student record from the system by their unique ID.
     * @param id The ID of the student to remove.
     * @return true if deleted successfully, false if ID not found.
     */
    boolean deleteStudent(int id);

    /**
     * Finds a specific student by their unique ID.
     * @param id The ID to search for.
     * @return The Student object if found, otherwise null.
     */
    Student findById(int id);
}
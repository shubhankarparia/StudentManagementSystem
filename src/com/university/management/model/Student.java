package com.university.management.model;

/**
 * Model class representing a Student entity.
 * Demonstrates Encapsulation - a core OOP concept.
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private String course;

    // Constructor
    public Student(int id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // --- GETTERS AND SETTERS (Encapsulation) ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Overriding toString() to display student details easily.
     */
    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-15s | Email: %-20s | Course: %s", 
                              id, name, email, course);
    }
}
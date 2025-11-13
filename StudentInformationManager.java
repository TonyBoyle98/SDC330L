//==============================================================
// Author: [Your Name]
// Date: [Date]
// File: StudentInformationManager.java
// Project: Student Information Manager (Project Week 1)
//==============================================================

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getAddress() {
        return city + ", " + state;
    }
}


class Student extends Person {
    private String studentID;
    private String major;
    private double gpa;
    private Address address; // Composition

    // Demonstrates inheritance (extends Person) and composition (has Address)
    public Student(String name, String studentID, String major, double gpa, Address address) {
        super(name);
        this.studentID = studentID;
        this.major = major;
        this.gpa = gpa;
        this.address = address;
    }

    public String getID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public double getGPA() {
        return gpa;
    }

    public void display() {
        System.out.printf("%-10s%-15s%-10s%.2f%n", studentID, name, major, gpa);
    }
}

// ------------------ Main Application ------------------
public class StudentInformationManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int choice;

        System.out.println("Welcome! This program helps manage student data.");

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete a Student Record");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1 -> {
                    // ----- Add New Student -----
                    System.out.println("\n--- Add New Student ---");
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter student major: ");
                    String major = scanner.nextLine();

                    System.out.print("Enter student GPA: ");
                    double gpa = getDoubleInput(scanner);

                    // City and state are placeholders to demonstrate composition
                    Address addr = new Address("Unknown", "Unknown");

                    students.add(new Student(name, id, major, gpa, addr));
                    System.out.println("\nStudent added successfully!");
                }

                case 2 -> {
                    // ----- Display All Students -----
                    System.out.println("\n--- Student List ---");
                    if (students.isEmpty()) {
                        System.out.println("No records to display.");
                    } else {
                        System.out.printf("%-10s%-15s%-10s%s%n", "ID", "Name", "Major", "GPA");
                        System.out.println("----------------------------------------------");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                }

                case 3 -> {
                    // ----- Search Student by ID -----
                    System.out.print("\nEnter student ID to search: ");
                    String id = scanner.nextLine();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.getID().equalsIgnoreCase(id)) {
                            System.out.println("\nRecord Found:");
                            System.out.printf("%-10s%-15s%-10s%s%n", "ID", "Name", "Major", "GPA");
                            System.out.println("----------------------------------------------");
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }

                case 4 -> {
                    // ----- Delete Student -----
                    System.out.print("\nEnter student ID to delete: ");
                    String id = scanner.nextLine();
                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getID().equalsIgnoreCase(id)) {
                            students.remove(i);
                            System.out.println("Student record deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student ID not found.");
                    }
                }

                case 5 -> {
                    // ----- Exit -----
                    System.out.println("\nThank you for using Student Information Manager!");
                    System.out.println("Goodbye!");
                }

                default -> {
                    if (choice < 1 || choice > 5) {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }

        } while (choice != 5);

        scanner.close();
    }

    // --- Helper Methods to Handle Input ---
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double num = Double.parseDouble(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid GPA: ");
            }
        }
    }
}
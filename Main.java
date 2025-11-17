/**********************
Name: Tony Boyle Jr
Date: 11/17/2025
Assignment: SDC330L Project
*******/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("  Project Week 1 - Rolodex Manager");
        System.out.println("  Created by: Tony Boyle Jr");
        System.out.println("====================================");
        System.out.println("Welcome! This program manages contacts.");
        System.out.println();

        int choice;

        do {
            showMenu();
            choice = getInt("Enter your choice: ");

            switch (choice) {
                case 1: addContact(); break;
                case 2: displayContacts(); break;
                case 3: searchContact(); break;
                case 4: updateContact(); break;
                case 5: deleteContact(); break;
                case 6:
                    System.out.println("Thank you for using Rolodex Contact Manager!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 6);
    }

    public static void showMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add a New Contact");
        System.out.println("2. Display All Contacts");
        System.out.println("3. Search Contact by ID");
        System.out.println("4. Update a Contact");
        System.out.println("5. Delete a Contact");
        System.out.println("6. Exit");
    }

    public static void addContact() {
        System.out.println("\n-- Add New Contact --");

        String id = getString("Enter Contact ID: ");
        String name = getString("Enter Name: ");
        String phone = getString("Enter Phone: ");
        String email = getString("Enter Email: ");

        System.out.println("Enter Address:");
        String street = getString("Street: ");
        String city = getString("City: ");
        String state = getString("State: ");

        Address address = new Address(street, city, state);

        System.out.println("Contact Type? (1 = Business, 2 = Personal)");
        int type = getInt("Choice: ");

        Contact newContact;

        if (type == 1) {
            String company = getString("Enter Company Name: ");
            newContact = new BusinessContact(id, name, address, phone, email, company);
        } else {
            String relationship = getString("Enter Relationship: ");
            newContact = new PersonalContact(id, name, address, phone, email, relationship);
        }

        contacts.add(newContact);
        System.out.println("Contact added successfully!");
    }

    public static void displayContacts() {
        System.out.println("\n-- Contact List --");
        System.out.printf("%-10s %-15s %-15s %-15s %-25s\n",
                "ID", "Name", "Type", "Phone", "Email");
        System.out.println("------------------------------------------------------------------");

        for (Contact c : contacts) {
            c.display();
        }
    }

    public static void searchContact() {
        String id = getString("Enter Contact ID to search: ");
        for (Contact c : contacts) {
            if (c.getContactID().equals(id)) {
                System.out.println("\nRecord Found:");
                c.display();
                return;
            }
        }
        System.out.println("No record found.");
    }

    public static void updateContact() {
        String id = getString("Enter Contact ID to update: ");
        for (Contact c : contacts) {

            if (c.getContactID().equals(id)) {
                String name = getString("Enter New Name: ");
                String phone = getString("Enter New Phone: ");
                String email = getString("Enter New Email: ");

                c.name = name;
                c.phone = phone;
                c.email = email;

                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("No record found.");
    }

    public static void deleteContact() {
        String id = getString("Enter Contact ID to delete: ");
        for (Contact c : contacts) {
            if (c.getContactID().equals(id)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("No record found.");
    }

    public static String getString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static int getInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }
}
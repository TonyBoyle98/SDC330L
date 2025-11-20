/********************
* Name: Tony Boyle Jr
* Date: 11/18/2025
* Assignment: Main program demonstrating inheritance, interface, polymorphism, and composition.
*********************/

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Project Week 2 ===");
        System.out.println("Rolodex Contact Application");
        System.out.println("Student: Martin\n");
        System.out.println("Welcome! This application demonstrates OOP concepts.\n");

        Rolodex rolodex = new Rolodex();

        // Instantiate contacts (required)
        BusinessContact b1 = new BusinessContact(
                "Sarah", "Kent", "555-1000", "s.kent@corp.com",
                "Kent Solutions", "Manager"
        );

        FamilyContact f1 = new FamilyContact(
                "Mike", "Andrews", "555-2222", "m.andrews@email.com",
                "Cousin"
        );

        FriendContact fr1 = new FriendContact(
                "Lily", "Mason", "555-3333", "lilym@gmail.com",
                "Lil", "Met at college"
        );

        // Add to Rolodex
        rolodex.addContact(b1);
        rolodex.addContact(f1);
        rolodex.addContact(fr1);

        // Display
        System.out.println("Displaying all contacts:\n");
        rolodex.displayAllContacts();

        // Polymorphic update (interface)
        System.out.println("Updating Lily's phone number...\n");
        fr1.updateContact("phone", "555-9999");

        System.out.println("Displaying all contacts after update:\n");
        rolodex.displayAllContacts();

        System.out.println("Contacts with last name starting with 'M':\n");
        rolodex.displayContactsByLetter('M');
    }
}
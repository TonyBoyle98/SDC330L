/**********************
Name: Tony Boyle Jr
Date: 11/17/2025
Assignment: SDC330L Project
*******/

public class Contact {
    protected String contactID;
    protected String name;
    protected Address address;    
    protected String phone;
    protected String email;

    public Contact(String contactID, String name, Address address, String phone, String email) {
        this.contactID = contactID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getContactID() { return contactID; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public String getContactType() {
        return "General Contact"; 
    }

    public void display() {
        System.out.printf("%-10s %-15s %-15s %-15s %-25s\n",
                contactID, name, getContactType(), phone, email);
    }
}

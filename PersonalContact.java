/**********************
Name: Tony Boyle Jr
Date: 11/17/2025
Assignment: SDC330L Project
*******/

public class PersonalContact extends Contact {

    private String relationship;

    public PersonalContact(String contactID, String name, Address address,
                           String phone, String email, String relationship) {
        super(contactID, name, address, phone, email);
        this.relationship = relationship;
    }

    @Override
    public String getContactType() {
        return "Personal";
    }

    public String getRelationship() {
        return relationship;
    }
}
/**********************
Name: Tony Boyle Jr
Date: 11/17/2025
Assignment: SDC330L Project
*******/

public class BusinessContact extends Contact {

    private String companyName;

    public BusinessContact(String contactID, String name, Address address, 
                           String phone, String email, String companyName) {
        super(contactID, name, address, phone, email);
        this.companyName = companyName;
    }

    @Override
    public String getContactType() {
        return "Business";
    }

    public String getCompanyName() {
        return companyName;
    }
}
//*********************************************************************

// File:        Contact.java

// Name:        Pravishna Nand

// Date:        8/6/2023

// Description: This class defines a Contact object with required fields including contact ID, 
//              first name, last name, phone, and address. It includes validation for all fields.

// Inputs:      contactId, firstName, lastName, phone, address

// Outputs:     None

// Process:     Validates each input according to the constraints like length and is not invalid.

// Assumptions: Assumes that the inputs provided when creating or updating the contact will be strings.

// Warnings:    None

//*********************************************************************

package ContactService;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor for initializing Contact object with validation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateName(firstName, "First Name");
        validateName(lastName, "Last Name");
        validatePhone(phone);
        validateAddress(address);
       
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
    // Getter methods section
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }
      
    // Setter methods section
    public void setFirstName(String firstName) {
        validateName(firstName, "First Name");
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        validateName(lastName, "Last Name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }
    
    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Validation methods section
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID is invalid");
        }
    }

    private void validateName(String name, String fieldName) {
        if (name == null || name.isEmpty() || name.length() > 10) {
            throw new IllegalArgumentException(fieldName + " is invalid");
        }
    }
    
    private void validatePhone(String phone) {
        if (phone == null || phone.isEmpty() || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number is invalid");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }
    }
}
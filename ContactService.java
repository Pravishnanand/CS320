//*********************************************************************
// File:        ContactService.java

// Name:        Pravishna Nand

// Date:        8/6/2023

// Description: This file provides a service for managing contacts. It allows adding, updating,
//              and deleting contacts based on a unique contact ID.  Updatable fields include
//              first name, last name, phone number, and address.

// Inputs:      Contact objects and individual contact attributes

// Outputs:     Contact information retrieval and update status.

// Process:     Uses a HashMap to store contacts and provides methods to manipulate them.

// Assumptions: Assumes that the Contact class is correctly implemented, and IDs are unique.

// Warnings:    None

//*********************************************************************

package ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts;
	
	public ContactService() {
		// Initialize the contacts map
		this.contacts = new HashMap<>();
	}
	
	public void addContact(Contact contact) {
        // Check for duplicate ID
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        // Add a contact with a unique ID
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        // Delete contact by its ID
        contacts.remove(contactId);
    }
    
    public void updateContactField(String contactId, String fieldName, String newValue) {
        // Retrieve the contact by its ID
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        // Update the appropriate field based on the fieldName provided
        switch (fieldName.toLowerCase()) {
            case "firstname":
                contact.setFirstName(newValue);
                break;
            case "lastname":
                contact.setLastName(newValue);
                break;
            case "phonenumber": // Updated field name to match requirement
                contact.setPhone(newValue);
                break;
            case "address":
                contact.setAddress(newValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid field name");
        }
    }

    public Contact getContact(String contactId) {
        // Retrieve contact by its ID
        return contacts.get(contactId);
    }
}	
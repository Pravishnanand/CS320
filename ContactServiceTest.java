//*********************************************************************
// File:        ContactServiceTest.java

// Name:        Pravishna Nand

// Date:        8/6/2023

// Description: This file contains test cases for the ContactService class to ensure that 
//              functions for adding, deleting, and updating contacts are working as expected.

// Inputs:      Contact objects and contact attributes.

// Outputs:     Success or failure of test cases.

// Process:     Utilizing JUnit to perform various assertions on the ContactService class.

// Assumptions: Assumes that the Contact and ContactService classes are correctly implemented.

// Warnings:    None

//*********************************************************************

package ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        // Create a ContactService instance and a sample contact for testing
        contactService = new ContactService();
        contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
    }

    @Test
    public void testAddContact() {
        // Test adding a contact and retrieving it by its ID
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact(contact.getContactId());
        assertEquals(contact, retrievedContact);
    }
    
    @Test
    public void testAddDuplicateContact() {
    	// Test duplicate contacts
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        // Test deleting a contact by its ID
        contactService.addContact(contact);
        contactService.deleteContact(contact.getContactId());
        Contact retrievedContact = contactService.getContact(contact.getContactId());
        assertNull(retrievedContact); // Expect the contact to be removed from the service
    }

    @Test
    public void testUpdateContactField() {
        // Test updating a specific field of a contact
        contactService.addContact(contact);
        String newFirstName = "Jessica";
        contactService.updateContactField(contact.getContactId(), "firstname", newFirstName);
        Contact updatedContact = contactService.getContact(contact.getContactId());
        assertEquals(newFirstName, updatedContact.getFirstName()); // Expect the first name to be updated
    }
    
    @Test
    public void testUpdateInvalidField() {
    	// Test updating invalid field
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField(contact.getContactId(), "invalid_field", "value"));
    }
    
    @Test
    public void testUpdateNonExistingContact() {
    	// Test updating non existing contact 
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("non_existing_id", "firstname", "value"));
    } 
}
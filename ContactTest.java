//*********************************************************************

// File:        ContactTest.java

// Name:        Pravishna Nand

// Date:        8/6/2023

// Description: This file contains test cases for the Contact class to ensure that validations for
//              contact ID, first name, last name, phone, and address are working as expected.

// Inputs:      Different combinations of valid and invalid contact information.

// Outputs:     Test results indicating success or failure of each test case.

// Process:     Utilizing JUnit to perform a variety of assertions on Contact object creation and validation.

// Assumptions: Assumes that the Contact class is correctly implemented.

// Warnings:    None

//*********************************************************************

package ContactService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContact() {
        // Testing valid contact creation
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Ashley", contact.getFirstName());
        assertEquals("Brown", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Luxerone St", contact.getAddress());
    }

    private void assertInvalidContactId(String contactId) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contact(contactId, "Ashley", "Brown", "1234567890", "123 Luxerone St"));
        assertEquals("Contact ID is invalid", exception.getMessage());
    }
    
    private void assertInvalidName(String firstName, String lastName, String fieldName) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", firstName, lastName, "1234567890", "123 Luxerone St"));
        assertEquals(fieldName + " is invalid", exception.getMessage());
    }

    private void assertInvalidPhone(String phone) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Ashley", "Brown", phone, "123 Luxerone St"));
        assertEquals("Phone number is invalid", exception.getMessage());
    }

    private void assertInvalidAddress(String address) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Ashley", "Brown", "1234567890", address));
        assertEquals("Address is invalid", exception.getMessage());
    }

    @Test
    public void testInvalidContactId() {
        assertInvalidContactId(null);
        assertInvalidContactId("");
        assertInvalidContactId("12345678901");
    }
    
    @Test
    public void testInvalidFirstName() {
        assertInvalidName(null, "Brown", "First Name");
        assertInvalidName("", "Brown", "First Name");
        assertInvalidName("SamanthaJackson", "Brown", "First Name"); // Assuming the length limit is 10
    }
    
    @Test
    public void testInvalidLastName() {
        assertInvalidName("Ashley", null, "Last Name");
        assertInvalidName("Ashley", "", "Last Name");
        assertInvalidName("Ashley", "SamanthaJackson", "Last Name"); // Assuming the length limit is 10
    }
    
    @Test
    public void testInvalidPhone() {
        assertInvalidPhone(null);
        assertInvalidPhone("");
        assertInvalidPhone("123456789");
    }

    @Test
    public void testInvalidAddress() {
        assertInvalidAddress(null);
        assertInvalidAddress("");
        assertInvalidAddress("This address is certainly longer than thirty characters");
    }
    
    @Test
    public void testSetValidFirstName() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        contact.setFirstName("James");
        assertEquals("James", contact.getFirstName());
    }
    
    @Test
    public void testSetInvalidFirstName() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("LongFirstName")); // Name with more than 10 characters
    }

    @Test
    public void testSetValidLastName() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetValidPhone() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetInvalidPhone() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789")); // Phone number with 9 digits
    }

    @Test
    public void testSetValidAddress() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        contact.setAddress("456 Another St");
        assertEquals("456 Another St", contact.getAddress());
    }

    @Test
    public void testSetInvalidAddress() {
        Contact contact = new Contact("1234567890", "Ashley", "Brown", "1234567890", "123 Luxerone St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is certainly longer than thirty characters"));
    }

    @Test
    public void testContactIdEdgeCase() {
        // Testing edge case for contact ID with 11 characters
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Ashley", "Brown", "1234567890", "123 Luxerone St"));
    }
}
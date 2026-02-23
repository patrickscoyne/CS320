package com.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	private ContactService service;
	private Contact newContact;
	
	// Instantiate ContactService and a create a valid contact to be used in tests.
	@BeforeEach
	void initService() {
		service = new ContactService();
		newContact = new Contact("1", "Peter", "Smith", "5555555555", "111 North Avenue");
	}
	
	// Test adding contact
	@Test
	void testAddContact() {
		
		service.addContact(newContact);
		Contact retContact = service.getContact("1");
		assertEquals("Peter", retContact.getFirstName());
		assertEquals("Smith", retContact.getLastName());
		assertEquals("5555555555", retContact.getPhone());
		assertEquals("111 North Avenue", retContact.getAddress());
	}

	// Test deleting contact
	@Test
	void testDeleteContact() {
		
		service.addContact(newContact);
		service.deleteContact("1");
		assertNull(service.getContact("1"));
	}

	// Test updating contact
	@Test
	void testUpdateContact() {
		
		service.addContact(newContact);
		service.updateContact("1", "UpFirst", "UpLast", "6666666666", "UpAddress");
		Contact upContact = service.getContact("1");
		assertEquals("UpFirst", upContact.getFirstName());
	    assertEquals("UpLast", upContact.getLastName());
	    assertEquals("UpAddress", upContact.getAddress());
	}
	
	// Test adding contact with duplicate ID.
	@Test
	void testAddDuplicateContact() {
		
		service.addContact(newContact);
		assertThrows(IllegalArgumentException.class, () -> service.addContact(newContact));
	}
	
	// Test adding null contact.
	@Test
	void testAddNullContact() {
	    assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}

	// Test deleting contact that does not exist.
	@Test
	void testDeleteNonExistentId() {
	    assertThrows(IllegalArgumentException.class, () -> service.deleteContact("4"));
	}

	// Test updating a contact that does not exist.
	@Test
	void testUpdateNonExistentId() {
	    assertThrows(IllegalArgumentException.class, () -> service.updateContact("4", "Steven", "Smith", "5555555555", "Henry Avenue"));
	}
	
	// Test getting a contact with null and empty ID
	@Test
	void testGetContactNullEmptyId() {
		assertThrows(IllegalArgumentException.class, () -> service.getContact(null));
		assertThrows(IllegalArgumentException.class, () -> service.getContact(""));
	}

}

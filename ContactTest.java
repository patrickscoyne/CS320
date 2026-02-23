package com.contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	private Contact validContact;

	// Initialize a valid contact to be used with each test
	@BeforeEach
	void initContact() {
		validContact = new Contact("1", "Peter", "Smith", "5555555555", "111 North Avenue");
	}
	
	// Test if contact was added correctly
	@Test
	void testValidContact() {
		assertEquals("1", validContact.getContactID());
		assertEquals("Peter", validContact.getFirstName());
		assertEquals("Smith", validContact.getLastName());
		assertEquals("5555555555", validContact.getPhone());
		assertEquals("111 North Avenue", validContact.getAddress());
	}
	
	// Test setting invalid ID (empty, null, and > 10 characters).
	@Test
	void testInvalidContactID() {
		assertThrows(IllegalArgumentException.class, () -> validContact = new Contact(" ", "Peter", "Smith", "5555555555", "111 North Avenue"));
		assertThrows(IllegalArgumentException.class, () -> validContact = new Contact(null, "Peter", "Smith", "5555555555", "111 North Avenue"));
		assertThrows(IllegalArgumentException.class, () -> validContact = new Contact("111111111111", "Peter", "Smith", "5555555555", "111 North Avenue"));
	}

	// Test setting invalid first name (> 10 characters, empty, and null).
	@Test
	void testSetInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () -> validContact.setFirstName("555555555555555555"));
		assertThrows(IllegalArgumentException.class, () -> validContact.setFirstName(" "));
		assertThrows(IllegalArgumentException.class, () -> validContact.setFirstName(null));
	}

	// Test setting invalid last name (> 10 characters, empty, and null).
	@Test
	void testSetInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () -> validContact.setLastName("555555555555555555"));
		assertThrows(IllegalArgumentException.class, () -> validContact.setLastName(" "));
		assertThrows(IllegalArgumentException.class, () -> validContact.setLastName(null));
	}

	// Test setting invalid phone number (Not exactly 10 digits, empty, and null).
	@Test
	void testSetInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () -> validContact.setPhone("555555555555555555"));
		assertThrows(IllegalArgumentException.class, () -> validContact.setPhone("55"));
		assertThrows(IllegalArgumentException.class, () -> validContact.setPhone("a"));
		assertThrows(IllegalArgumentException.class, () -> validContact.setPhone(" "));
		assertThrows(IllegalArgumentException.class, () -> validContact.setPhone(null));
	}

	// Test setting invalid address (empty, > 30 characters, and null).
	@Test
	void testSetInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () -> validContact.setAddress(" "));
		assertThrows(IllegalArgumentException.class, () -> validContact.setAddress("11111111111111111111111111111111"));
		assertThrows(IllegalArgumentException.class, () -> validContact.setAddress(null));
	}

}

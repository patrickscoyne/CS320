package com.contacts;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// Create Hash Map of Contact list with ContactID as key
	private final Map<String, Contact> contactList = new HashMap<>();
	
		// Add contact method with null check and existing contact check
		public void addContact(Contact contact) {
			if (contact == null) {
		        throw new IllegalArgumentException("Contact cannot be null.");
		    }
			if (contactList.containsKey(contact.getContactID()) ) {
				throw new IllegalArgumentException("Contact cannot be added. Contact ID exists.");
			}
			contactList.put(contact.getContactID(), contact);
		}
	
		// Delete contact method with non existent ID check
		public void deleteContact(String contactID) {
			if (!contactList.containsKey(contactID)) {
				throw new IllegalArgumentException("Cannot delete contact. Contact ID does not exist.");
			}
			contactList.remove(contactID);
		}
		
		// Update contact method with non existent ID check
		public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
			Contact contact = contactList.get(contactID);
			if (contact == null) {
				throw new IllegalArgumentException("Cannot update contact. Contact ID does not exist.");
			}
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setPhone(phone);
			contact.setAddress(address);
		}
		
		// Get contact method with null/empty check
		public Contact getContact(String contactID) {
			if (contactID == null || contactID.trim().isEmpty()) {
				throw new IllegalArgumentException("ContactID cannot be empty or null");
			}
			return contactList.get(contactID);
		}

}

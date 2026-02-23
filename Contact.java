package com.contacts;

public class Contact {
	
	// Declare variables
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Constructor to set ContactID (making it not updatable).
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		if (contactID == null || contactID.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid ContactID. ContactID cannot be empty or null");
		}
		if (contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ContactID. ContactID cannot be longer than 10 characters");
		}
		this.contactID = contactID;
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}

	// Getter methods
	
	public String getContactID() {
		return contactID;
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
	
	// Setter methods with validation
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("First name cannot be null or empty");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name cannot be longer than 10 characters");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Last name cannot be null or empty");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
			throw new IllegalArgumentException("Phone number cannot be null or empty");
		}
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid Phone Number. Phone number must be 10 digits");
        }
        this.phone = phone;
    }
	
	public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Address. Address cannot be null or empty");
        }
        if (address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address. Address cannot be longer than 30 characters");
		}
        this.address = address;
    }
}

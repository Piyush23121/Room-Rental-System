package com.example.dto;

public class LandlordDto {

	private int OwnerId;
	private String FirstName;
	private String LastName;
	private String EmailId;
	private String Password;
	private String Phone;
	
	public LandlordDto(String firstName, String lastName, String emailId, String password, String phone) {
		super();
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
		Password = password;
		Phone = phone;
	}

	public LandlordDto() {
		super();
	}

	public int getOwnerId() {
		return OwnerId;
	}

	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
}

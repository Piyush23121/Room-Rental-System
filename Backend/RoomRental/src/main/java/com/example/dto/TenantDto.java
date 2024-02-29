package com.example.dto;

public class TenantDto {

	private int TenantId;
	private String FirstName;
	private String LastName;
	private String EmailId;
	private String Password;
	private String Phone;
	
	public int getTenantId() {
		return TenantId;
	}
	public void setTenantId(int tenantId) {
		TenantId = tenantId;
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

	public TenantDto(String firstName, String lastName, String emailId, String password, String phone) {
		super();
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
		Password = password;
		Phone = phone;
	}
	public TenantDto() {
		super();
	}
	
}

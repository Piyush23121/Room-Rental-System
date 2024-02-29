package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Landlord")
public class Landlord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LandlordId")
	private int OwnerId;
	@Column(name="FirstName")
	private String FirstName;
	@Column(name="LastName")
	private String LastName;
	@Column(name="EmailId")
	private String EmailId;
	@Column(name="Password")
	private String Password;
	@Column(name="Phone")
	private String Phone;
	
	@OneToMany(mappedBy = "ownerId" ,cascade = CascadeType.ALL,orphanRemoval = true)
	List<Property> propertyList=new ArrayList<Property>();
	
	public void addProperty(Property property) {	// helper Method 
		this.propertyList.add(property);
		property.setOwnerId(this);
	}
	
	public void removeProperty(Property property) {
		this.propertyList.remove(property);
		property.setOwnerId(null);
	}
	
	public List<Property> getProperty() {
		return propertyList;
	}
	public void setProperty(List<Property> property) {
		this.propertyList = property;
	}
	public Landlord(String firstName, String lastName, String emailId, String password, String phone) {
		super();
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
		Password = password;
		Phone = phone;
	}
	public Landlord() {
		super();
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
	public String getFirstName() {
		return FirstName;
	}
	public int getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
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
	@Override
	public String toString() {
		return "Landlord [OwnerId=" + OwnerId + ", FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}
}

package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TenantId;
	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "EmailId")
	private String EmailId;
	@Column(name = "Password")
	private String Password;
	@Column(name = "Phone")
	private String Phone;

	@OneToOne(mappedBy="tenantId")
	private Property property;
	
	public void addProperty(Property property) {
		property.setTenantId(this);
	}
	public void removeProperty(Property property) {
		property.setTenantId(null);
	}
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	/*
	 * @OneToOne(mappedBy = "tenantId", cascade = CascadeType.ALL) List<Property>
	 * propertyList = new ArrayList<Property>();
	 * 
	 * public void addProperty(Property property) { this.propertyList.add(property);
	 * property.setTenantId(this); }
	 * 
	 * public void removeProperty(Property property) {
	 * this.propertyList.remove(property); property.setTenantId(null); }
	 * 
	 * public List<Property> getPropertyList() { return propertyList; }
	 * 
	 * public void setPropertyList(List<Property> propertyList) { this.propertyList
	 * = propertyList; }
	 */
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

	
	public Tenant(String firstName, String lastName, String emailId, String password, String phone) {
		super();
		FirstName = firstName;
		LastName = lastName;
		EmailId = emailId;
		Password = password;
		Phone = phone;
	}

	public Tenant() {
		super();
	}

	@Override
	public String toString() {
		return "Tenant [TenantId=" + TenantId + ", FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}
}

package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.entity.enums.RoomType;
import com.example.entity.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PropertyId;
	@Column(name = "Area", nullable = false)
	private String Area;
	@Column(name = "City", nullable = false)
	private String City;
	@Column(name = "State", nullable = false)
	private String State;
	@Column(name = "Rent", nullable = false)
	private float Rent;
	@Column(name ="Deposit", nullable = false)
	private float Deposit;
	@Column(name = "Status", nullable = false)
	private boolean Status;
	@Column(name = "UserType", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType User;
	@Column(name = "RoomType")
	@Enumerated(EnumType.STRING)
	private RoomType Room;
	@Column(name = "Facilities")
	private String Facilities;
	@Column(name = "Pincode", nullable = false)
	private String Pincode;
	@Column(name = "Address", nullable = false)
	private String Address;
	public float getDeposit() {
		return Deposit;
	}

	public void setDeposit(float deposit) {
		Deposit = deposit;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OwnerId",nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	Landlord ownerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TenantId",referencedColumnName = "TenantId")
	@JsonProperty(access = Access.WRITE_ONLY)
	Tenant tenantId;

	public UserType getUser() {
		return User;
	}

	public void setUser(UserType user) {
		User = user;
	}

	public RoomType getRoom() {
		return Room;
	}

	public void setRoom(RoomType room) {
		Room = room;
	}

	public String getFacilities() {
		return Facilities;
	}

	public void setFacilities(String facilities) {
		Facilities = facilities;
	}

	public int getPropertyId() {
		return PropertyId;
	}

	public void setPropertyId(int propertyId) {
		PropertyId = propertyId;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public float getRent() {
		return Rent;
	}

	public void setRent(float rent) {
		Rent = rent;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Landlord getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Landlord ownerId) {
		this.ownerId = ownerId;
	}

	public Tenant getTenantId() {
		return tenantId;
	}

	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}

	public Property(int propertyId, String area, String city, String state, float rent, boolean status,
			String facilities, String pincode, String address, Landlord ownerId, Tenant tenantId, RoomType room,
			UserType user,float deposit) {
		super();
		PropertyId = propertyId;
		Area = area;
		City = city;
		State = state;
		Rent = rent;
		Status = status;
		Facilities = facilities;
		Pincode = pincode;
		Address = address;
		this.ownerId = ownerId;
		this.tenantId = tenantId;
		Room = room;
		User = user;
		Deposit =deposit;
	}

	public Property(int propertyId) {
		super();
		PropertyId = propertyId;
	}

	public Property() {
		super();
	}

	@Override
	public String toString() {
		return "Property [PropertyId=" + PropertyId + ", Area=" + Area + ", City=" + City + ", State=" + State
				+ ", Rent=" + Rent + ", Status=" + Status + ", User=" + User + ", Facilities=" + Facilities
				+ ", Pincode=" + Pincode + ", Address=" + Address + ", Room=" + Room + "]";
	}

	
}

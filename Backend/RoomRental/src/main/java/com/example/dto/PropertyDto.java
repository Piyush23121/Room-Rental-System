package com.example.dto;

import com.example.entity.Landlord;
import com.example.entity.Tenant;
import com.example.entity.enums.RoomType;
import com.example.entity.enums.UserType;

public class PropertyDto {

	private int PropertyId;
	private String Area;
	private String City;
	private String State;
	private float Rent;
	private boolean Status;
	private String Facilities;
	private String Address;
	private int tenantId;
	private int ownerId;
	private float Deposit;
	private UserType User;
	private RoomType Room;
	private String Pincode;
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public PropertyDto(int propertyId, String area, String city, String state, float rent, boolean status,
			String facilities, String pincode,String address, int tenantId, int ownerId, RoomType room, UserType user, float deposit) {
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
		this.tenantId = tenantId;
		this.ownerId = ownerId;
		Room = room;
		User = user;
		Deposit = deposit;
	}

	public PropertyDto() {
		super();
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId.getTenantId();
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Landlord ownerId) {
		this.ownerId = ownerId.getOwnerId();
	}

	public float getDeposit() {
		return Deposit;
	}

	public void setDeposit(float deposit) {
		Deposit = deposit;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}
}

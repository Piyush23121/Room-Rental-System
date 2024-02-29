package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="Image")
public class Image {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ImageId;
	@Column(name="Name")
	private String Name;
	@Column (name = "ImageType")
	private String Type;	//Jpeg,Jpg,Png
	@Lob
	@Column(name="PicBytes",length = Integer.MAX_VALUE,nullable = true)
	private byte[] PicBytes;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PropertyId")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Property propertyId;
	
	public Image(int imageId, String name, String type, byte[] picBytes, Property propertyId) {
		super();
		ImageId = imageId;
		Name = name;
		Type = type;
		PicBytes = picBytes;
		this.propertyId = propertyId;
	}
	public Property getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}
	public int getImageId() {
		return ImageId;
	}
	public void setImageId(int imageId) {
		ImageId = imageId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public byte[] getPicBytes() {
		return PicBytes;
	}
	public void setPicBytes(byte[] picBytes) {
		PicBytes = picBytes;
	}
}

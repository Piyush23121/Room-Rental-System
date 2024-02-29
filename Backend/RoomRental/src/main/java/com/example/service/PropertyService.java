package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSInput;

import com.example.dto.PropertyDto;
import com.example.entity.Landlord;
import com.example.entity.Property;
import com.example.repository.LandlordRepository;
import com.example.repository.PropertyRepository;
import com.example.repository.TenantRepository;

@Service
@Transactional
public class PropertyService {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	PropertyRepository propertyRepo;
	@Autowired
	LandlordRepository landlordRepo;
	@Autowired
	TenantRepository tenantRepo;
	
	public PropertyDto addProperty(PropertyDto propertyDto) {
		Landlord landlord = landlordRepo.getReferenceById(propertyDto.getOwnerId());
		Property property = this.modelMapper.map(propertyDto, Property.class);
		landlord.addProperty(property);
		Property addProperty = this.propertyRepo.save(property);
		PropertyDto propertyDTO = this.modelMapper.map(addProperty, PropertyDto.class);
		return propertyDTO;
	}
	
	public List<String> getAreaList(){
		return this.propertyRepo.getAllArea();
	}

	public List<PropertyDto> getAllProperty() {
		List<Property> properties = this.propertyRepo.findAll();
		List<PropertyDto> propertiesDto = properties.stream()
				.map((property) -> this.modelMapper.map(property, PropertyDto.class)).collect(Collectors.toList());
		return propertiesDto;
	}

	public List<PropertyDto> getAvailableProperty(){
		List<Property> properties = this.propertyRepo.getAllAvailableProperty();
		List<PropertyDto> propertiesDto = properties.stream()
				.map((property) -> this.modelMapper.map(property, PropertyDto.class)).collect(Collectors.toList());
		return propertiesDto;
	}
	
	public PropertyDto getPropertyById(int propertyId) {
		Property property = propertyRepo.findById(propertyId).get();
		return this.modelMapper.map(property, PropertyDto.class);
	}

	public void deleteProperty(int propertyId) {
		Property property = this.propertyRepo.findById(propertyId).get();
		propertyRepo.delete(property);
	}
	
	public List<PropertyDto> getAllPropertyByOwner(int ownerId){
		Landlord landlord = landlordRepo.getReferenceById(ownerId);
		List<Property> property=this.propertyRepo.findByOwnerId(ownerId);
		List<PropertyDto> propertyDto=property.stream().map((_property)->this.modelMapper.map(_property,PropertyDto.class)).collect(Collectors.toList());
		return propertyDto;
	}
	
	public int updateTenat(int propertyId ,int tenantId) {
		return this.propertyRepo.updateTenatId(tenantId,propertyId); 
	}

}

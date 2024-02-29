package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PropertyDto;
import com.example.service.PropertyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<PropertyDto> getAvailableProperty(){
		return propertyService.getAvailableProperty();
	}
//	public List<PropertyDto> getAllProperty() {
//		return propertyService.getAllProperty();
//	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public PropertyDto getProperty(@PathVariable int id) {
		return propertyService.getPropertyById(id);
	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PropertyDto addProperty(@RequestBody PropertyDto propertyDto) {
		return propertyService.addProperty(propertyDto);
	}

	@DeleteMapping("/delete/{id}")
	public String removeProperty(@PathVariable int id) {
		propertyService.deleteProperty(id);
		return "Property Deleted";
	}
	@PutMapping("/{tenantId}/{propertyId}")
	public int updateTenant(@PathVariable int tenantId ,@PathVariable int propertyId){
		return propertyService.updateTenat(propertyId, tenantId);
	}
	@PostMapping("/landlord/{ownerId}")
	public List<PropertyDto> getAllPropertyByOwner(@PathVariable int ownerId){
		return this.propertyService.getAllPropertyByOwner(ownerId);
	}
	@GetMapping("/area")
	public List<String> getAllArea(){
		return this.propertyService.getAreaList();
	}
}

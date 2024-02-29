package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.LandlordDto;
import com.example.dto.LoginDto;
import com.example.service.LandlordService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/landlord")
public class LandlordController {

	@Autowired
	LandlordService landlordService;

	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<LandlordDto> getAllLandlord() {
		return landlordService.getAllLandlord();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public LandlordDto getLandlordById(@PathVariable int id) {
		return landlordService.getLandlordById(id);
	}

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public LandlordDto addLandlord(@RequestBody LandlordDto landlordDto) {
		LandlordDto addLandlordDto = landlordService.addLandlord(landlordDto);
		return addLandlordDto;
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String removeLandlord(@PathVariable int id) {
		landlordService.deleteLandlord(id);
		return "User Deleted";
	}
	
	@PostMapping("/login")
	public LandlordDto loginLandlord(@RequestBody LoginDto credentials) {
		return landlordService.loginLandlord(credentials.getEmail(), credentials.getPassword());
	}
}

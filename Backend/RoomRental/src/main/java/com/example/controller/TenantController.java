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

import com.example.dto.LoginDto;
import com.example.dto.TenantDto;
import com.example.service.TenantService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	TenantService tenantService;
	
	@GetMapping("/")
	@ResponseStatus(code=HttpStatus.OK)
	public List<TenantDto> getAllTenant(){
		return tenantService.getAllTenant();
	}
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public TenantDto getTenant(@PathVariable int id) {
		return tenantService.getTenantById(id);
	}
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public TenantDto addTenant(@RequestBody TenantDto tenatDto) {
		TenantDto addTenantDto =tenantService.addTenant(tenatDto);
		return addTenantDto;
	}
	@DeleteMapping("/Delete/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public String removeTenant(@PathVariable int id) {
		tenantService.deleteTenant(id);
		return "Tenant Deleted";
	}
	
	@PostMapping("/login")
	public TenantDto loginTenant(@RequestBody LoginDto credentials) {
		return tenantService.loginTenant(credentials.getEmail(), credentials.getPassword());
	}
	
}

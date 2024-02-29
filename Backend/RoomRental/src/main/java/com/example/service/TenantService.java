package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.TenantDto;
import com.example.entity.Tenant;
import com.example.repository.TenantRepository;

@Service
public class TenantService {

	@Autowired
	TenantRepository tenantRepo;
	@Autowired
	ModelMapper modelMapper;

	public TenantDto addTenant(TenantDto tenantDto) {
		Tenant tenant = this.modelMapper.map(tenantDto, Tenant.class);
		Tenant addTenant = this.tenantRepo.save(tenant);
		TenantDto tenantDTO = this.modelMapper.map(addTenant, TenantDto.class);
		return tenantDTO;
	}

	public TenantDto getTenantById(int tenantId) {
		Tenant tenant = tenantRepo.findById(tenantId).get();
		return this.modelMapper.map(tenant, TenantDto.class);
	}

	public List<TenantDto> getAllTenant() {
		List<Tenant> tenants = this.tenantRepo.findAll();
		List<TenantDto> tenantsDto = tenants.stream().map((tenant) -> this.modelMapper.map(tenant, TenantDto.class))
				.collect(Collectors.toList());
		return tenantsDto;
	}

	public void deleteTenant(int tenantId) {
		Tenant tenant = this.tenantRepo.findById(tenantId).get();
		tenantRepo.delete(tenant);
	}
	
	public TenantDto loginTenant(String email,String password) {
		try {
			Tenant tenant =tenantRepo.findByEmailAndPassword(email, password).get();
			return modelMapper.map(tenant,TenantDto.class);
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			return null;
		} 
	}
}

package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LandlordDto;
import com.example.entity.Landlord;
import com.example.repository.LandlordRepository;

@Service
public class LandlordService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private LandlordRepository landlordRepo;

	public LandlordDto addLandlord(LandlordDto landlordDto) {
		Landlord landlord = this.modelMapper.map(landlordDto, Landlord.class);
		Landlord addLandlord = this.landlordRepo.save(landlord);
		LandlordDto landlordDTO = this.modelMapper.map(addLandlord, LandlordDto.class);
		return landlordDTO;
	}

	public LandlordDto getLandlordById(int landlordId) {
		Landlord landlord = landlordRepo.findById(landlordId).get(); // here add custom exception if Landlord Does not
																		// exists with help of orElseThrow
		return this.modelMapper.map(landlord, LandlordDto.class);
	}

	public List<LandlordDto> getAllLandlord() {
		List<Landlord> landlords = this.landlordRepo.findAll();
		List<LandlordDto> landlordsDto = landlords.stream()
				.map((landlord) -> this.modelMapper.map(landlord, LandlordDto.class)).collect(Collectors.toList());
		return landlordsDto;
	}

	public void deleteLandlord(int landlordId) {
		Landlord landlord = this.landlordRepo.findById(landlordId).get(); // here add custom exception if Landlord Does
																			// not exists with help of orElseThrow
		landlordRepo.delete(landlord);
	}
	
	public LandlordDto loginLandlord(String email,String password) {
		try {
			Landlord landlord =landlordRepo.findByEmailAndPassword(email, password).get();
			return modelMapper.map(landlord,LandlordDto.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Credntials");
			return null;
		}
	}

}

package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Landlord;

public interface LandlordRepository extends JpaRepository<Landlord,Integer> {

//	@Transactional
//	@Modifying
//	@Query(value="update landlord set landlord.first_name= :firstName , landlord.last_name= :lastname , landlord.email_id= :email ")
//	Optional<Landlord> updateLandlord(@Param("firstName") String firstname,@Param("lastName") String lastname,@Param("email") String email);
	@Query(value = "Select owner from Landlord owner where owner.EmailId = :emailId and owner.Password = :password")
	Optional<Landlord> findByEmailAndPassword(@Param("emailId") String emailId,@Param("password") String password);
//	Optional<Landlord> findByEmailAndPassword(String emailId,String password);
	
}

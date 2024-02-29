package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {

	@Query(value = "Select user from Tenant user where user.EmailId = :email and user.Password = :password")
	Optional<Tenant> findByEmailAndPassword(@Param("email") String email ,@Param("password") String password); // optional for orElseThrow function
	
	//@Modifying for put  
}

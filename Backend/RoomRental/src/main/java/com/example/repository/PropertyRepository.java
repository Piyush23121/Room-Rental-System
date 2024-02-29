package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	@Modifying
	@Query(value = "Update property set tenant_id = :tenantId where property_id = :propertyId",nativeQuery = true)
	int updateTenatId(@Param("tenantId") int tenantId,@Param("propertyId") int propertyId);
	
//	@Query(value="select property.property_id,property.address,property.area,property.city,property.deposit,property.facilities,property.pincode,property.rent,property.state,property.user_type,property.room_type from property where property.status=true",nativeQuery = true)
	@Query(value="Select * from property where property.status=true",nativeQuery = true)
	List<Property> getAllAvailableProperty();
	@Query(value = "Select area from property" ,nativeQuery = true)
	List<String> getAllArea();
	
	@Query(value ="Select * from property where property.owner_id= :ownerid", nativeQuery = true)
	List<Property> findByOwnerId(@Param("ownerid") int ownerid);
	
	@Query(value = "Select property from Property property where property.Area = :area")
	List<Property> findByArea(@Param("area") String area);
	
	@Query(value = "Select property from Property property where property.City = :city")
	List<Property> findByCity(@Param("city") String city);
	
	@Query(value = "Select property from Property property where property.Facilities = :facilities")
	List<Property> findByFacility(@Param("facilities") String facilities);
	
	@Query(value = "Select property from Property property where property.Area = :area and property.City = :city")
	List<Property> findByAreaAndCity(@Param("area") String area,@Param("city") String city);
	
//	@Query("Select property from Property property where property.Area = :area and property.City = :city and property.PropertyType = :propertyType")
//	List<Property> findByAreaAnd
	
}

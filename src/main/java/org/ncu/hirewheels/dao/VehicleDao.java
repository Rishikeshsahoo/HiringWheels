package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.Vehicle_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByVehicleSubcategory_VehicleCategory_VehicleCategoryName(String categoryName);

    // You can add custom query methods here if needed

	List<Vehicle> findByVehicleCategory(Vehicle_Category vehicleCategory);
	 Location findByLocation(Location location);

	

}
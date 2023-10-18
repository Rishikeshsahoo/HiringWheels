package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Vehicle_CategoryDao extends JpaRepository<Vehicle_Category, Long> {
    // Define custom query methods here
    List<Vehicle_Category> findByVehicleCategoryNameIgnoreCase(String vehicleCategoryName);
    // Add more custom query methods as needed
}
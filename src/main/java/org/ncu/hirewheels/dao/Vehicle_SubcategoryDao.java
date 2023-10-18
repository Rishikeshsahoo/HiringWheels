package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle_Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Vehicle_SubcategoryDao extends JpaRepository<Vehicle_Subcategory, Long> {
    // Define custom query methods here
    List<Vehicle_Subcategory> findByVehicleSubcategoryNameIgnoreCase(String vehicleSubcategoryName);
    List<Vehicle_Subcategory> findByPricePerDayLessThan(double price);
    // Add more custom query methods as needed
}
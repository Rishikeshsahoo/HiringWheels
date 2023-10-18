package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle_Subcategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Vehicle_SubcategoryDaoimpl {
    @PersistenceContext
    private EntityManager entityManager;

    // Implement custom query methods using EntityManager
    public List<Vehicle_Subcategory> findByVehicleSubcategoryNameIgnoreCase(String vehicleSubcategoryName) {
        // Implement the query logic here using EntityManager
        return null;  // Replace with your query logic
    }

    public List<Vehicle_Subcategory> findByPricePerDayLessThan(double price) {
        // Implement the query logic here using EntityManager
        return null;  // Replace with your query logic
    }
    
    // Add more custom query methods as needed
}
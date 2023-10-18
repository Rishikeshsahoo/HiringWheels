package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Fuel_Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Fuel_TypeDao extends JpaRepository<Fuel_Type, Long> {
    List<Fuel_Type> findByFuelTypeIgnoreCase(String fuelType);
}
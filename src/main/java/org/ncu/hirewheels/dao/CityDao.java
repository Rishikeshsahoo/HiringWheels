package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City, Long> {
    List<City> findByCityNameIgnoreCase(String cityName);
}
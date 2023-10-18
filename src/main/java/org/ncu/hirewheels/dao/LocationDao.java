package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationDao extends JpaRepository<Location, Long> {
    List<Location> findByLocationNameIgnoreCase(String locationName);
}
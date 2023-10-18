package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.VehicleDao;

import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hirewheels/v1/vehicles")
public class AdminController {

    private final VehicleDao vehicleRepository;
    private final LocationDao locationRepository;

    @Autowired
    public AdminController(VehicleDao vehicleRepository, LocationDao locationRepository) {
        this.vehicleRepository = vehicleRepository;
        this.locationRepository = locationRepository;
    }

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
        try {
            // Save the new vehicle to the database
            Vehicle savedVehicle = vehicleRepository.save(vehicle);

            // Generate a response
            String responseMessage = "Vehicle successfully added to the database. Vehicle ID: " + savedVehicle.getVehicleId();

            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hirewheels/v1")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        // Check if vehicles exist and return them with HttpStatus.OK
        if (!vehicles.isEmpty()) {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } else {
            // If no vehicles are found, you can return an appropriate status, e.g., HttpStatus.NO_CONTENT
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

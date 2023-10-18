package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.Vehicle_Category;
import org.ncu.hirewheels.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public List<Vehicle> getAllVehicles() {
        // Retrieve all registered vehicles from the database
        return vehicleDao.findAll();
    }
    public List<Vehicle> getAvailableVehicles(Vehicle_Category vehicleCategory, String pickupLocation, String pickupDateTime, String dropOffDateTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();

        // Step 1: Fetch a list of vehicles for the input Vehicle Category
        List<Vehicle> vehiclesByCategory = vehicleDao.findByVehicleCategory(vehicleCategory); // Replace with your actual query method

        for (Vehicle vehicle : vehiclesByCategory) {
            // Step 2a: Check vehicle's availability status
            if (vehicle.getAvailabilityStatus() == 1) {
                // Step 2b: Verify if the vehicle is available at the pickup location
                if (isVehicleAvailableAtLocation(vehicle, pickupLocation)) {
                    // Step 2c: Check whether the vehicle is available for booking between pickup and drop-off dates
                    if (isVehicleAvailableForBooking(vehicle, pickupDateTime, dropOffDateTime)) {
                        // Step 3: Vehicle passes all checks, add it to the list of available vehicles
                        availableVehicles.add(vehicle);
                    }
                }
            }
        }

        // Step 4: Return the list of available vehicles
        return availableVehicles;
    }
	private boolean isVehicleAvailableForBooking(Vehicle vehicle, String pickupDateTime, String dropOffDateTime) {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean isVehicleAvailableAtLocation(Vehicle vehicle, String pickupLocation) {
		// TODO Auto-generated method stub
		return false;
	}


}

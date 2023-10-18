package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        // Set availability_status to 1 by default
        vehicle.setAvailabilityStatus(1);
        
        // Insert the new vehicle into the database
        return vehicleDao.save(vehicle);
    }
    @Override
    public boolean changeAvailability(Long vehicleId, boolean isAvailable) {
        // Retrieve the vehicle from the database
        Vehicle vehicle = vehicleDao.findById(vehicleId).orElse(null);

        if (vehicle != null) {
            // Update the availability status
            vehicle.setAvailabilityStatus(isAvailable ? 1 : 0);
            // Save the updated vehicle
            vehicle = vehicleDao.save(vehicle);
            return vehicle != null;
        } else {
            // Handle the case where the vehicle is not found
            return null != null;
        }
    }
}

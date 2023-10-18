package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.Vehicle_Category;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getAvailableVehicles(Vehicle_Category vehicleCategoryName, String pickupLocation, String pickupDateTime, String dropOffDateTime);
}

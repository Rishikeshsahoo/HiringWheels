package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

public interface AdminService {
    Vehicle registerVehicle(Vehicle vehicle);
    boolean changeAvailability(Long vehicleId, boolean isAvailable);
}
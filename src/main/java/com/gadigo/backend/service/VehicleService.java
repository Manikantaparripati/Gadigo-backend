package com.gadigo.backend.service;

import com.gadigo.backend.model.Vehicle;
import com.gadigo.backend.model.VehicleType;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehiclesByType(VehicleType type);
    Optional<Vehicle> getVehicleById(String id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(String id, Vehicle vehicle);
    void deleteVehicle(String id);
    List<Vehicle> getVehiclesByOwner(String ownerId);
}

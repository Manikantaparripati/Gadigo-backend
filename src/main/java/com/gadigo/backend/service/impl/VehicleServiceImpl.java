package com.gadigo.backend.service.impl;

import com.gadigo.backend.model.Vehicle;
import com.gadigo.backend.model.VehicleType;
import com.gadigo.backend.repository.VehicleRepository;
import com.gadigo.backend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByType(VehicleType type) {
        return vehicleRepository.findByType(type);
    }

    @Override
    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicle.setCreatedAt(LocalDateTime.now());
        if (vehicle.getIsAvailable() == null) {
            vehicle.setIsAvailable(true);
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(String id, Vehicle vehicleDetails) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            vehicle.setMake(vehicleDetails.getMake());
            vehicle.setModel(vehicleDetails.getModel());
            vehicle.setYear(vehicleDetails.getYear());
            vehicle.setPricePerDay(vehicleDetails.getPricePerDay());
            vehicle.setLocation(vehicleDetails.getLocation());
            vehicle.setImages(vehicleDetails.getImages());
            vehicle.setFeatures(vehicleDetails.getFeatures());
            vehicle.setIsAvailable(vehicleDetails.getIsAvailable());
            return vehicleRepository.save(vehicle);
        }
        throw new RuntimeException("Vehicle not found with id " + id);
    }

    @Override
    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getVehiclesByOwner(String ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }
}

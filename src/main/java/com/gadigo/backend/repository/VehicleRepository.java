package com.gadigo.backend.repository;

import com.gadigo.backend.model.Vehicle;
import com.gadigo.backend.model.VehicleType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    List<Vehicle> findByType(VehicleType type);
    List<Vehicle> findByOwnerId(String ownerId);
    List<Vehicle> findByIsAvailable(Boolean isAvailable);
}

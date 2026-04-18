package com.gadigo.backend.repository;

import com.gadigo.backend.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {
    List<Place> findByNameContainingIgnoreCase(String name);
}

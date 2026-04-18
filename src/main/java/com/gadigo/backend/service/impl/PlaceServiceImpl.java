package com.gadigo.backend.service.impl;

import com.gadigo.backend.model.Place;
import com.gadigo.backend.repository.PlaceRepository;
import com.gadigo.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> searchPlaces(String query) {
        return placeRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public Optional<Place> getPlaceById(String id) {
        return placeRepository.findById(id);
    }

    @Override
    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Place updatePlace(String id, Place placeDetails) {
        return placeRepository.findById(id).map(existingPlace -> {
            existingPlace.setName(placeDetails.getName());
            existingPlace.setDescription(placeDetails.getDescription());
            existingPlace.setLocation(placeDetails.getLocation());
            existingPlace.setPopularAttractions(placeDetails.getPopularAttractions());
            existingPlace.setImages(placeDetails.getImages());
            return placeRepository.save(existingPlace);
        }).orElseThrow(() -> new RuntimeException("Place not found with id: " + id));
    }

    @Override
    public void deletePlace(String id) {
        placeRepository.deleteById(id);
    }
}

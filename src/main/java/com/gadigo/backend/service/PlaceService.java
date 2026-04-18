package com.gadigo.backend.service;

import com.gadigo.backend.model.Place;
import java.util.List;
import java.util.Optional;

public interface PlaceService {
    List<Place> getAllPlaces();
    List<Place> searchPlaces(String query);
    Optional<Place> getPlaceById(String id);
    Place createPlace(Place place);
    Place updatePlace(String id, Place place);
    void deletePlace(String id);
}

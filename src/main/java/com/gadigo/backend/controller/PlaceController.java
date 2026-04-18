package com.gadigo.backend.controller;

import com.gadigo.backend.model.Place;
import com.gadigo.backend.payload.response.MessageResponse;
import com.gadigo.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces(@RequestParam(required = false) String q) {
        if (q != null && !q.isEmpty()) {
            return placeService.searchPlaces(q);
        }
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable String id) {
        return placeService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Place> updatePlace(@PathVariable String id, @RequestBody Place place) {
        try {
            return ResponseEntity.ok(placeService.updatePlace(id, place));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePlace(@PathVariable String id) {
        placeService.deletePlace(id);
        return ResponseEntity.ok(new MessageResponse("Place deleted successfully"));
    }
}

package com.gadigo.backend.controller;

import com.gadigo.backend.model.Package;
import com.gadigo.backend.payload.response.MessageResponse;
import com.gadigo.backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable String id) {
        return packageService.getPackageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Package createPackage(@RequestBody Package touristPackage) {
        return packageService.createPackage(touristPackage);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Package> updatePackage(@PathVariable String id, @RequestBody Package touristPackage) {
        try {
            return ResponseEntity.ok(packageService.updatePackage(id, touristPackage));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePackage(@PathVariable String id) {
        packageService.deletePackage(id);
        return ResponseEntity.ok(new MessageResponse("Package deleted successfully"));
    }
}

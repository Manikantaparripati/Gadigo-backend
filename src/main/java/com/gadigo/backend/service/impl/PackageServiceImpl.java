package com.gadigo.backend.service.impl;

import com.gadigo.backend.model.Package;
import com.gadigo.backend.repository.PackageRepository;
import com.gadigo.backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public Optional<Package> getPackageById(String id) {
        return packageRepository.findById(id);
    }

    @Override
    public Package createPackage(Package touristPackage) {
        touristPackage.setCreatedAt(LocalDateTime.now());
        return packageRepository.save(touristPackage);
    }

    @Override
    public Package updatePackage(String id, Package packageDetails) {
        return packageRepository.findById(id).map(existingPackage -> {
            existingPackage.setTitle(packageDetails.getTitle());
            existingPackage.setDescription(packageDetails.getDescription());
            existingPackage.setPrice(packageDetails.getPrice());
            existingPackage.setDurationDays(packageDetails.getDurationDays());
            existingPackage.setItinerary(packageDetails.getItinerary());
            existingPackage.setImages(packageDetails.getImages());
            return packageRepository.save(existingPackage);
        }).orElseThrow(() -> new RuntimeException("Package not found with id: " + id));
    }

    @Override
    public void deletePackage(String id) {
        packageRepository.deleteById(id);
    }
}

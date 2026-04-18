package com.gadigo.backend.service;

import com.gadigo.backend.model.Package;
import java.util.List;
import java.util.Optional;

public interface PackageService {
    List<Package> getAllPackages();
    Optional<Package> getPackageById(String id);
    Package createPackage(Package touristPackage);
    Package updatePackage(String id, Package touristPackage);
    void deletePackage(String id);
}

package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dao.LocationRepository;
import com.followdeklerk.persistentworldservice.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(String locationName, String description) {
        Location location = new Location();
        location.setLocationName(locationName);
        location.setDescription(description);
        return location;
    }

    public Location updateLocation(Long id, String locationName, String description) {
        Location location = locationRepository.findById(id).orElseThrow();
        location.setId(id);
        location.setLocationName(locationName);
        location.setDescription(description);
        return location;
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow();
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationByName(String locationName) {
        return locationRepository.findByName(locationName);
    }

    public List<Location> getLocationsWithEnemies() {
        return locationRepository.findByEnemiesIsNotNull();
    }

}
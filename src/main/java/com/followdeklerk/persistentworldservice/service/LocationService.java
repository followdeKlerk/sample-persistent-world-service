package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dto.LocationDto;
import com.followdeklerk.persistentworldservice.entity.Location;
import com.followdeklerk.persistentworldservice.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationDto createLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setName(locationDto.getName());
        location.setDescription(locationDto.getDescription());
        return locationRepository.save(location).toDto();
    }

    public LocationDto updateLocation(Long id, LocationDto locationDto) {
        Location location = locationRepository.findById(id).orElseThrow();
        location.setId(id);
        location.setName(locationDto.getName());
        location.setDescription(locationDto.getDescription());
        return locationRepository.save(location).toDto();
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    public LocationDto getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow().toDto();
    }

    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : locations) {
            locationDtos.add(location.toDto());
        }
        return locationDtos;
    }

    public LocationDto getLocationByName(String locationName) {
        return locationRepository.findByName(locationName).toDto();
    }

    public List<LocationDto> getLocationsWithEnemies() {
        return locationRepository.findByEnemiesIsNotNull().stream().map(Location::toDto).collect(Collectors.toList());
    }

}
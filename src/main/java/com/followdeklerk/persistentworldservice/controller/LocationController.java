package com.followdeklerk.persistentworldservice.controller;

import com.followdeklerk.persistentworldservice.dto.LocationDto;
import com.followdeklerk.persistentworldservice.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/create")
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        return new ResponseEntity<>(locationService.createLocation(locationDto), HttpStatus.CREATED);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        return new ResponseEntity<>(locationService.updateLocation(id, locationDto), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.getLocationById(id), HttpStatus.OK);
    }

    @RequestMapping("/getByName/{locationName}")
    public ResponseEntity<LocationDto> getLocationByName(@PathVariable String locationName) {
        return new ResponseEntity<>(locationService.getLocationByName(locationName), HttpStatus.OK);
    }

    @RequestMapping("/getWithEnemies")
    public ResponseEntity<List<LocationDto>> getLocationsWithEnemies() {
        return new ResponseEntity<>(locationService.getLocationsWithEnemies(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

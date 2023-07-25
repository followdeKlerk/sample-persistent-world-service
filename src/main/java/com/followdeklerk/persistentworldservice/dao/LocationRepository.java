package com.followdeklerk.persistentworldservice.dao;

import com.followdeklerk.persistentworldservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByName(String locationName);

    List<Location> findByEnemiesIsNotNull();
}


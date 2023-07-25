package com.followdeklerk.persistentworldservice.dao;

import com.followdeklerk.persistentworldservice.entity.Location;
import com.followdeklerk.persistentworldservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.location = :location")
    List<Player> findAllByLocation(Location location);
}

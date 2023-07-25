package com.followdeklerk.persistentworldservice.dao;

import com.followdeklerk.persistentworldservice.entity.Inventory;
import com.followdeklerk.persistentworldservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByPlayer(Player player);
}

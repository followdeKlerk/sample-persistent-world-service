package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dao.InventoryRepository;
import com.followdeklerk.persistentworldservice.dao.PlayerRepository;
import com.followdeklerk.persistentworldservice.entity.Inventory;
import com.followdeklerk.persistentworldservice.entity.Item;
import com.followdeklerk.persistentworldservice.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(Player player) {
        Inventory inventory = new Inventory();
        inventory.setPlayer(player);
        return inventory;
    }

    public Inventory updateInventory(Long id, List<Item> items) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow();
        inventory.setItems(items);
        return inventory;
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow();
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryByPlayer(Player player) {
        return inventoryRepository.findByPlayer(player);
    }

}

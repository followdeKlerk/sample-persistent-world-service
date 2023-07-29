package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dto.InventoryDto;
import com.followdeklerk.persistentworldservice.entity.Inventory;
import com.followdeklerk.persistentworldservice.entity.Player;
import com.followdeklerk.persistentworldservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setPlayer(inventoryDto.getPlayer());
        inventory.setItems(inventoryDto.getItems());
        return inventoryDto;
    }

    public InventoryDto updateInventory(Long id, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow();
        inventory.setItems(inventoryDto.getItems());
        return inventoryDto;
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    public InventoryDto getInventoryById(Long id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow();
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setPlayer(inventory.getPlayer());
        inventoryDto.setItems(inventory.getItems());
        return inventoryDto;
    }

    public List<InventoryDto> getAllInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for (Inventory inventory : inventories) {
            InventoryDto inventoryDto = new InventoryDto();
            inventoryDto.setPlayer(inventory.getPlayer());
            inventoryDto.setItems(inventory.getItems());
            inventoryDtos.add(inventoryDto);
        }
        return inventoryDtos;
    }

    public InventoryDto getInventoryByPlayer(Player player) {
        Inventory inventory = inventoryRepository.findByPlayer(player);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setPlayer(inventory.getPlayer());
        inventoryDto.setItems(inventory.getItems());
        return inventoryDto;
    }

}
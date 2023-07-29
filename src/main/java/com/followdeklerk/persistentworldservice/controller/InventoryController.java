package com.followdeklerk.persistentworldservice.controller;

import com.followdeklerk.persistentworldservice.dto.InventoryDto;
import com.followdeklerk.persistentworldservice.dto.PlayerDto;
import com.followdeklerk.persistentworldservice.entity.Player;
import com.followdeklerk.persistentworldservice.service.InventoryService;
import com.followdeklerk.persistentworldservice.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    private final PlayerService playerService;

    public InventoryController(InventoryService inventoryService, PlayerService playerService) {
        this.inventoryService = inventoryService;
        this.playerService = playerService;
    }

    Logger logger = Logger.getLogger(InventoryController.class.getName());

    @RequestMapping("/create")
    public ResponseEntity<InventoryDto> createInventory(@Validated @RequestBody InventoryDto inventoryDto) {
        return new ResponseEntity<>(inventoryService.createInventory(inventoryDto), HttpStatus.CREATED);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable Long id, @Validated @RequestBody InventoryDto inventoryDto) {
        return new ResponseEntity<>(inventoryService.updateInventory(id, inventoryDto), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable Long id) {
        return new ResponseEntity<>(inventoryService.getInventoryById(id), HttpStatus.OK);
    }

    @RequestMapping("/inventory/{id}")
    public ResponseEntity<InventoryDto> getInventoryByPlayer(@PathVariable Long id) {
        PlayerDto playerDto = playerService.findPlayerById(id);

        if (playerDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Player player = playerDto.toPlayer();
        InventoryDto inventory = inventoryService.getInventoryByPlayer(player);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setPlayer(player);
        inventoryDto.setItems(inventory.getItems());

        return new ResponseEntity<>(inventoryDto, HttpStatus.OK);
    }


    @RequestMapping("/all")
    public ResponseEntity<List<InventoryDto>> getAllInventories() {
        return new ResponseEntity<>(inventoryService.getAllInventories(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

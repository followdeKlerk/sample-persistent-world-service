package com.followdeklerk.persistentworldservice.controller;

import com.followdeklerk.persistentworldservice.dto.ItemDto;
import com.followdeklerk.persistentworldservice.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    Logger logger = Logger.getLogger(ItemController.class.getName());

    @RequestMapping("/create")
    public ResponseEntity<ItemDto> createItem(@Validated @RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.createItem(itemDto), HttpStatus.CREATED);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @Validated @RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.updateItem(id, itemDto), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @RequestMapping("/inventory/{itemType}")
    public ResponseEntity<ItemDto> getItemsByType(@PathVariable String itemType) {
        return new ResponseEntity<>(itemService.getItemsByType(itemType), HttpStatus.OK);
    }

    @RequestMapping("/equipped/{equipped}")
    public ResponseEntity<ItemDto> getEquippedItems(@PathVariable Boolean equipped) {
        return new ResponseEntity<>(itemService.getEquippedItems(equipped), HttpStatus.OK);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

package com.followdeklerk.persistentworldservice.controller;

import com.followdeklerk.persistentworldservice.dto.DamageTypeDto;
import com.followdeklerk.persistentworldservice.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/damage")
public class DamageTypeController {

    private final DamageTypeService damageTypeService;

    @Autowired
    public DamageTypeController(DamageTypeService damageTypeService) {
        this.damageTypeService = damageTypeService;
    }

    Logger logger = Logger.getLogger(DamageTypeController.class.getName());

    @RequestMapping("/create")
    public ResponseEntity<DamageTypeDto> createDamageType(@Validated @RequestBody DamageTypeDto damageTypeDto) {

        if (damageTypeDto.getDamageType() == null || damageTypeDto.getDamageType().isEmpty()) {
            throw new IllegalArgumentException("Damage type cannot be null or empty");
        }

        if (damageTypeDto.getModifier() < 0) {
            throw new IllegalArgumentException("Damage modifier cannot be negative");
        }

        return new ResponseEntity<>(damageTypeService.createDamageType(damageTypeDto), HttpStatus.CREATED);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<DamageTypeDto> updateDamageType(@PathVariable Long id, @Validated @RequestBody DamageTypeDto damageTypeDto) {
        return new ResponseEntity<>(damageTypeService.updateDamageType(id, damageTypeDto), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDamageType(@PathVariable Long id) {
        damageTypeService.deleteDamageType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<DamageTypeDto> getDamageTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(damageTypeService.getDamageTypeById(id), HttpStatus.OK);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<DamageTypeDto>> getAllDamageTypes() {
        return new ResponseEntity<>(damageTypeService.getAllDamageTypes(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
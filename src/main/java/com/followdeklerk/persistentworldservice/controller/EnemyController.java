package com.followdeklerk.persistentworldservice.controller;

import com.followdeklerk.persistentworldservice.dto.EnemyDto;
import com.followdeklerk.persistentworldservice.service.EnemyService;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enemy")
public class EnemyController {

    private final EnemyService enemyService;

    public EnemyController(EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    Logger logger = org.slf4j.LoggerFactory.getLogger(EnemyController.class);

    @RequestMapping("/all")
    public ResponseEntity<List<EnemyDto>> getAllEnemies() {
        return new ResponseEntity<>(enemyService.getAllEnemies(), HttpStatus.OK);
    }

    @RequestMapping("/create")
    public ResponseEntity<EnemyDto> createEnemy(@Validated @RequestBody EnemyDto enemyDto) {

        if (enemyDto.getEnemyName() == null || enemyDto.getEnemyName().isEmpty()) {
            throw new IllegalArgumentException("Enemy name cannot be null or empty");
        }

        if (enemyDto.getLevel() < 0) {
            throw new IllegalArgumentException("Enemy level cannot be negative");
        }

        EnemyDto createdEnemy = enemyService.createEnemy(enemyDto);

        logger.info("Created enemy: {}", createdEnemy);

        return new ResponseEntity<>(createdEnemy, HttpStatus.CREATED);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<EnemyDto> updateEnemy(@PathVariable Long id, @Validated @RequestBody EnemyDto enemyDto) {
        return new ResponseEntity<>(enemyService.updateEnemy(id, enemyDto), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEnemy(@PathVariable Long id) {
        enemyService.deleteEnemy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<EnemyDto> getEnemyById(@PathVariable Long id) {
        return new ResponseEntity<>(enemyService.getEnemyById(id), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

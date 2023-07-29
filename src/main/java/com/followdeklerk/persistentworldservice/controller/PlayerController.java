package com.followdeklerk.persistentworldservice.controller;

import com.followdeklerk.persistentworldservice.dto.PlayerDto;
import com.followdeklerk.persistentworldservice.service.PlayerService;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    Logger logger = org.slf4j.LoggerFactory.getLogger(PlayerController.class);

    @RequestMapping("/all")
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @RequestMapping("/create")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerdto) {
        if (playerdto.getName() == null || playerdto.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }

        if (playerdto.getExperiencePoints() < 0) {
            throw new IllegalArgumentException("Player experience points cannot be negative");
        }

        PlayerDto createdPlayer = playerService.createPlayer(playerdto);

        logger.info("Created player: {}", createdPlayer);

        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<PlayerDto> findPlayerById(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.findPlayerById(id), HttpStatus.OK);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return new ResponseEntity<>(playerService.updatePlayer(id, playerDto), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
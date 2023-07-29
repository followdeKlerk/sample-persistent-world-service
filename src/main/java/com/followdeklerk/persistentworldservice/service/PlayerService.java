package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dto.EnemyDto;
import com.followdeklerk.persistentworldservice.dto.LocationDto;
import com.followdeklerk.persistentworldservice.dto.PlayerDto;
import com.followdeklerk.persistentworldservice.entity.Enemy;
import com.followdeklerk.persistentworldservice.entity.Player;
import com.followdeklerk.persistentworldservice.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setExperiencePoints(playerDto.getExperiencePoints());
        player.setLevel(playerDto.getLevel());
        player.setMaxHealth(playerDto.getMaxHealth());
        player.setInventory(playerDto.getInventory());
        return playerRepository.save(player).toDto();
    }

    public PlayerDto updatePlayer(Long id, PlayerDto playerDto) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setName(playerDto.getName());
        player.setExperiencePoints(playerDto.getExperiencePoints());
        player.setLevel(playerDto.getLevel());
        player.setMaxHealth(playerDto.getMaxHealth());
        player.setInventory(playerDto.getInventory());
        return playerRepository.save(player).toDto();
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public PlayerDto findPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow().toDto();
    }

    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : players) {
            playerDtos.add(player.toDto());
        }
        return playerDtos;
    }

    public int calculateExperienceGain(PlayerDto playerDto, EnemyDto enemyDto) {
        int experienceGain = enemyDto.getLevel() * 10;
        if (playerDto.getLevel() > enemyDto.getLevel()) {
            experienceGain = experienceGain / 2;
        }
        return experienceGain;
    }

    public void levelUp(PlayerDto playerDto) {
        if (playerDto.getExperiencePoints() >= playerDto.getLevel() * 100) {
            playerDto.setLevel(playerDto.getLevel() + 1);
            playerDto.setExperiencePoints(0);
        }
    }

    public boolean isPlayerInLocation(PlayerDto playerDto, LocationDto locationDto) {
        return playerDto.getLocation().equals(locationDto);
    }

    public List<EnemyDto> getEnemiesInLocation(LocationDto locationDto) {
        List<EnemyDto> enemies = new ArrayList<>();
        for (Enemy enemy : locationDto.getEnemies()) {
            if (Enemy.isAlive(enemy)) {
                enemies.add(enemy.toDto());
            }
        }
        return enemies;
    }

}
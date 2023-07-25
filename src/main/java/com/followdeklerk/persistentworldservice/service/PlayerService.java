package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dao.PlayerRepository;
import com.followdeklerk.persistentworldservice.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(String name, int experiencePoints, int level, int maxHealth, Inventory inventory){
    Player player = new Player();
    player.setName(name);
    player.setExperiencePoints(experiencePoints);
    player.setLevel(level);
    player.setMaxHealth(maxHealth);
    player.setInventory(inventory);
    return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, String name, int experiencePoints, int level, int maxHealth, Inventory inventory){
        Player player = playerRepository.findById(id).orElseThrow();
        player.setName(name);
        player.setExperiencePoints(experiencePoints);
        player.setLevel(level);
        player.setMaxHealth(maxHealth);
        player.setInventory(inventory);
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player findPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    public List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }

    public int calculateExperienceGain(Player player, Enemy enemy) {
        int experienceGain = enemy.getLevel() * 10;
        if (player.getLevel() > enemy.getLevel()) {
            experienceGain = experienceGain / 2;
        }
        return experienceGain;
    }

    public void levelUp(Player player){
        if (player.getExperiencePoints() >= player.getLevel() * 100) {
            player.setLevel(player.getLevel() + 1);
            player.setExperiencePoints(0);
        }
    }

    public boolean isPlayerInLocation (Player player, Location location){
        return player.getLocation().equals(location);
    }

    public List<Enemy> getEnemiesInLocation (Location location){
        List<Enemy> enemies = new ArrayList<>();
        for (Enemy enemy : location.getEnemies()) {
            if (Enemy.isAlive(enemy)) {
                enemies.add(enemy);
            }
        }
        return enemies;
    }

}

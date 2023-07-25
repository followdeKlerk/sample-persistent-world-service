package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dao.EnemyRepository;
import com.followdeklerk.persistentworldservice.entity.Enemy;
import com.followdeklerk.persistentworldservice.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnemyService {

    private final EnemyRepository enemyRepository;

    public EnemyService(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    public Enemy createEnemy(String enemyName, int level, int maxHealth, Location location) {
        Enemy enemy = new Enemy();
        enemy.setEnemyName(enemyName);
        enemy.setLevel(level);
        enemy.setMaxHealth(maxHealth);
        enemy.setLocation(location);
        return enemy;
    }
    public Enemy updateEnemy(Long id, String enemyName, int level, int health, Location location, boolean isAlive) {
        Enemy enemy = enemyRepository.findById(id).orElseThrow();
        enemy.setEnemyName(enemyName);
        enemy.setLevel(level);
        enemy.setEnemyHealth(health);
        enemy.setLocation(location);
        enemy.setAlive(isAlive);
        return enemy;
    }
    public void deleteEnemy(Long id) {
        enemyRepository.deleteById(id);
    }
    public Enemy getEnemyById(Long id) {
        return enemyRepository.findById(id).orElseThrow();
    }
    public List<Enemy> getAllEnemies() {
        return enemyRepository.findAll();
    }

}

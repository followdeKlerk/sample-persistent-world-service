package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dto.EnemyDto;
import com.followdeklerk.persistentworldservice.entity.Enemy;
import com.followdeklerk.persistentworldservice.repository.EnemyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnemyService {

    private final EnemyRepository enemyRepository;

    public EnemyService(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    public EnemyDto createEnemy(EnemyDto enemyDto) {
        Enemy enemy = new Enemy();
        enemy.setEnemyName(enemyDto.getEnemyName());
        enemy.setLevel(enemyDto.getLevel());
        enemy.setMaxHealth(enemyDto.getMaxHealth());
        enemy.setLocation(enemyDto.getLocation());
        return enemyRepository.save(enemy).toDto();
    }

    public EnemyDto updateEnemy(Long id, EnemyDto enemyDto) {
        Enemy enemy = enemyRepository.findById(id).orElseThrow();
        enemy.setEnemyName(enemyDto.getEnemyName());
        enemy.setLevel(enemyDto.getLevel());
        enemy.setEnemyHealth(enemyDto.getEnemyHealth());
        enemy.setLocation(enemyDto.getLocation());
        enemy.setAlive(enemyDto.isAlive());
        return enemyRepository.save(enemy).toDto();
    }

    public void deleteEnemy(Long id) {
        enemyRepository.deleteById(id);
    }

    public EnemyDto getEnemyById(Long id) {
        return enemyRepository.findById(id).orElseThrow().toDto();
    }

    public List<EnemyDto> getAllEnemies() {
        List<Enemy> enemies = enemyRepository.findAll();
        List<EnemyDto> enemyDtos = new ArrayList<>();
        for (Enemy enemy : enemies) {
            enemyDtos.add(enemy.toDto());
        }
        return enemyDtos;
    }

}


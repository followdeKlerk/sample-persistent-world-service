package com.followdeklerk.persistentworldservice.dto;

import com.followdeklerk.persistentworldservice.entity.DamageType;
import com.followdeklerk.persistentworldservice.entity.Enemy;
import com.followdeklerk.persistentworldservice.entity.Location;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EnemyDto {

    private Long id;

    private String enemyName;

    private Location location;

    private Integer enemyHealth;

    private Integer maxHealth;

    private Integer level;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer version;

    private boolean isDeleted;

    private Integer attack;

    private Integer defense;

    private String attackType;

    private List<DamageType> damageType;

    private boolean isAlive;

    public static boolean isAlive(Enemy enemy) {
        return enemy.getEnemyHealth() > 0;
    }
}

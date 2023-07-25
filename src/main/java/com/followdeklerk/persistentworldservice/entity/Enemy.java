package com.followdeklerk.persistentworldservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enemry_name")
    private String enemyName;

    @ManyToOne
    private Location location;

    @Column(name = "enemy_health")
    private Integer enemyHealth;

    @Column(name = "max_health")
    private Integer maxHealth;

    @Column(name = "level")
    private Integer level;

    @Column(name = "description")
    private String description;

    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "deleted")
    private boolean isDeleted;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "attack_type")
    private String attackType;

    @OneToMany(mappedBy = "enemy")
    @Column(name = "damage_type")
    @ToString.Exclude
    private List<DamageType> damageType;

    @Column(name = "is_alive")
    private boolean isAlive;

    public static boolean isAlive(Enemy enemy) {
        return enemy.enemyHealth > 0;
    }

}

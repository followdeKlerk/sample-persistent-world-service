package com.followdeklerk.persistentworldservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "experience_points")
    private Integer experiencePoints;

    @Column(name = "level")
    private Integer level;

    @Column(name = "max_health")
    private Integer maxHealth;

    @Column(name = "health")
    private Integer health;

    @ManyToOne
    private Inventory inventory;

    @ManyToOne
    private Location location;

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

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "attack_type")
    private String attackType;

    @OneToMany(mappedBy = "player")
    @Column(name = "damage_type")
    @ToString.Exclude
    private List<DamageType> damageType;

    @Column(name = "strength")
    private Integer Strength;

    @Column(name = "intelligence")
    private Integer intelligence;
}

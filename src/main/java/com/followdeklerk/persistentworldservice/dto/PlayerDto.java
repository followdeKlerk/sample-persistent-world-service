package com.followdeklerk.persistentworldservice.dto;

import com.followdeklerk.persistentworldservice.entity.DamageType;
import com.followdeklerk.persistentworldservice.entity.Inventory;
import com.followdeklerk.persistentworldservice.entity.Location;
import com.followdeklerk.persistentworldservice.entity.Player;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Long id;

    private String name;

    private Integer experiencePoints;

    private Integer level;

    private Integer maxHealth;

    private Integer health;

    private Inventory inventory;

    private Location location;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer version;

    private boolean isDeleted;

    private String createdBy;

    private String updatedBy;

    private Integer attack;

    private Integer defense;

    private String attackType;

    private List<DamageType> damageType;

    private Integer strength;

    private Integer intelligence;

    public Player toPlayer() {
        Player player = new Player();
        player.setName(this.getName());
        player.setExperiencePoints(this.getExperiencePoints());
        player.setLevel(this.getLevel());
        player.setMaxHealth(this.getMaxHealth());
        player.setHealth(this.getHealth());
        player.setInventory(this.getInventory());
        player.setLocation(this.getLocation());
        player.setDescription(this.getDescription());
        player.setCreatedAt(this.getCreatedAt());
        player.setUpdatedAt(this.getUpdatedAt());
        player.setAttack(this.getAttack());
        player.setDefense(this.getDefense());
        player.setAttackType(this.getAttackType());
        player.setDamageType(this.getDamageType());
        player.setStrength(this.getStrength());
        player.setIntelligence(this.getIntelligence());
        player.setVersion(this.getVersion());
        return player;
    }

}

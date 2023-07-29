package com.followdeklerk.persistentworldservice.dto;

import com.followdeklerk.persistentworldservice.entity.Enemy;
import com.followdeklerk.persistentworldservice.entity.Player;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DamageTypeDto {

    private Long id;

    private String damageType;

    private Integer modifier;

    private Player player;

    private Enemy enemy;
}

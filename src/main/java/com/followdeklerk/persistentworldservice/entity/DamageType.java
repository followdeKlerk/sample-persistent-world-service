package com.followdeklerk.persistentworldservice.entity;

import com.followdeklerk.persistentworldservice.dto.DamageTypeDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class DamageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "damage_type")
    private String damageType;

    @Column(name = "modifier")
    private Integer modifier;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Enemy enemy;

    public DamageTypeDto toDto() {
        DamageTypeDto damageTypeDto = new DamageTypeDto();
        damageTypeDto.setDamageType(this.damageType);
        damageTypeDto.setModifier(this.modifier);
        return damageTypeDto;
    }
}
package com.followdeklerk.persistentworldservice.entity;

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

    @Column(name = "physical_damage")
    private String physicalDamage;

    @Column(name = "magical_damage")
    private String magicalDamage;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Enemy enemy;

}

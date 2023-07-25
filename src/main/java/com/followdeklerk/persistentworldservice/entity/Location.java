package com.followdeklerk.persistentworldservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String locationName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    private List<Enemy> enemies;

}

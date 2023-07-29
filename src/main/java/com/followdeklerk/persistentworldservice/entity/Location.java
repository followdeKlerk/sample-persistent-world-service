package com.followdeklerk.persistentworldservice.entity;

import com.followdeklerk.persistentworldservice.dto.LocationDto;
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
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    private List<Enemy> enemies;

    public LocationDto toDto() {
        LocationDto locationDto = new LocationDto();
        locationDto.setName(this.getName());
        locationDto.setDescription(this.getDescription());
        locationDto.setEnemies(this.getEnemies());
        return locationDto;
    }
}

package com.followdeklerk.persistentworldservice.dto;

import com.followdeklerk.persistentworldservice.entity.Enemy;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private Long id;

    private String name;

    private String description;

    private List<Enemy> enemies;
}

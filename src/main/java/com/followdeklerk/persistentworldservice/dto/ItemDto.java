package com.followdeklerk.persistentworldservice.dto;

import com.followdeklerk.persistentworldservice.entity.Inventory;
import com.followdeklerk.persistentworldservice.entity.Location;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;

    private String itemName;

    private String itemDescription;

    private Inventory inventory;

    private Integer dropChance;

    private String itemType;

    private boolean equipped;

    private Integer quantity;

    private Location location;
}

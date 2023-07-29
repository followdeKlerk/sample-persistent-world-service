package com.followdeklerk.persistentworldservice.dto;

import com.followdeklerk.persistentworldservice.entity.Item;
import com.followdeklerk.persistentworldservice.entity.Player;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {

    private Long id;

    private List<Item> items;

    private Player player;
}

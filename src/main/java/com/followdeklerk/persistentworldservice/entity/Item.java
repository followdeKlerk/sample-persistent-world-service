package com.followdeklerk.persistentworldservice.entity;

import com.followdeklerk.persistentworldservice.dto.ItemDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Column(name = "drop_chance")
    private Integer dropChance;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "equipped")
    private boolean equipped;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public ItemDto toDto() {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemName(this.getItemName());
        itemDto.setItemDescription(this.getItemDescription());
        itemDto.setInventory(this.getInventory());
        itemDto.setDropChance(this.getDropChance());
        itemDto.setItemType(this.getItemType());
        itemDto.setEquipped(this.isEquipped());
        return itemDto;
    }
}
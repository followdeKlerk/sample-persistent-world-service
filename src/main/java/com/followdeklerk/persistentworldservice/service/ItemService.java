package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dto.ItemDto;
import com.followdeklerk.persistentworldservice.entity.Item;
import com.followdeklerk.persistentworldservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDto createItem(ItemDto itemDto) {
        Item item = new Item();
        item.setItemName(itemDto.getItemName());
        item.setItemDescription(itemDto.getItemDescription());
        item.setDropChance(itemDto.getDropChance());
        item.setItemType(itemDto.getItemType());
        return itemRepository.save(item).toDto();
    }

    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setItemName(itemDto.getItemName());
        item.setItemDescription(itemDto.getItemDescription());
        item.setDropChance(itemDto.getDropChance());
        item.setItemType(itemDto.getItemType());
        return itemRepository.save(item).toDto();
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public ItemDto getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow().toDto();
    }

    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            itemDtos.add(item.toDto());
        }
        return itemDtos;
    }

    public ItemDto getItemsByType(String itemType) {
        return itemRepository.findByItemType(itemType).toDto();
    }

    public ItemDto getEquippedItems(Boolean equipped) {
        return itemRepository.findByEquipped(equipped).toDto();
    }
}
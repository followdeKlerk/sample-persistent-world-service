package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dao.ItemRepository;
import com.followdeklerk.persistentworldservice.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(String itemName, String itemDescription) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        return item;
    }

    public Item updateItem(Long id, String itemName, String itemDescription) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setId(id);
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        return item;
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemsByType(String itemType) {
        return itemRepository.findByItemType(itemType);

    }

    public Item getEquippedItems(Boolean equipped) {
        return itemRepository.findByEquipped(equipped);
    }

    public void getInventoryItems(int inventoryId) {
        itemRepository.getInventoryItems(inventoryId);
    }
}

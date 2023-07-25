    package com.followdeklerk.persistentworldservice.dao;

    import com.followdeklerk.persistentworldservice.entity.Item;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface ItemRepository extends JpaRepository<Item, Long> {
        Item findByItemType(String itemType);

        Item findByEquipped(Boolean equipped);

        void getInventoryItems(int inventoryId);
    }


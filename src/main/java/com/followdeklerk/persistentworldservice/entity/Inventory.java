    package com.followdeklerk.persistentworldservice.entity;

    import jakarta.persistence.*;
    import lombok.*;

    import java.util.List;

    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    @Entity
    public class Inventory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "inventory")
        @ToString.Exclude
        private List<Item> items;

        @ManyToOne
        private Player player;

    }

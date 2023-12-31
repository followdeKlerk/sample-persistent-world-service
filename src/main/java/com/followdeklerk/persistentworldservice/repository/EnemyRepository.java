package com.followdeklerk.persistentworldservice.repository;

import com.followdeklerk.persistentworldservice.entity.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
}

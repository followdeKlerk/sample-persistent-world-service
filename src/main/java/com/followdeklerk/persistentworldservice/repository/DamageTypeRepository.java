package com.followdeklerk.persistentworldservice.repository;

import com.followdeklerk.persistentworldservice.entity.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageTypeRepository extends JpaRepository<DamageType, Long> {
}

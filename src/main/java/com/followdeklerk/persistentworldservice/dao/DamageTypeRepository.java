package com.followdeklerk.persistentworldservice.dao;

import com.followdeklerk.persistentworldservice.entity.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageTypeRepository extends JpaRepository<DamageType, Long> {
}

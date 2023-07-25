package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dao.DamageTypeRepository;
import com.followdeklerk.persistentworldservice.entity.DamageType;
import com.followdeklerk.persistentworldservice.entity.Enemy;
import com.followdeklerk.persistentworldservice.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageTypeService {

    private final DamageTypeRepository damageTypeRepository;

    public DamageTypeService (DamageTypeRepository damageTypeRepository) {
        this.damageTypeRepository = damageTypeRepository;
    }

    public DamageType createDamageType(String physicalDamage, String magicalDamage) {
        DamageType damageType = new DamageType();
        damageType.setPhysicalDamage(physicalDamage);
        damageType.setMagicalDamage(magicalDamage);
        return damageTypeRepository.save(damageType);
    }

    public DamageType updateDamageType(Long id, String physicalDamage, String magicalDamage) {
        DamageType damageType = damageTypeRepository.findById(id).orElseThrow();
        damageType.setPhysicalDamage(physicalDamage);
        damageType.setMagicalDamage(magicalDamage);
        return damageTypeRepository.save(damageType);
    }

    public void deleteDamageType(Long id) {
        damageTypeRepository.deleteById(id);
    }

    public DamageType getDamageTypeById(Long id) {
        return damageTypeRepository.findById(id).orElseThrow();
    }

    public List<DamageType> getAllDamageTypes() {
        return damageTypeRepository.findAll();
    }

    public int calculateDamage(DamageType damageType, Player player, Enemy enemy) {
        int damage = 0;
        if (damageType.getPhysicalDamage() != null) {
            damage += player.getStrength() * Integer.parseInt(damageType.getPhysicalDamage());
        }
        if (damageType.getMagicalDamage() != null) {
            damage += player.getIntelligence() * Integer.parseInt(damageType.getMagicalDamage());
        }
        return damage;
    }

    public int calculateTotalDamage(Player player, Enemy enemy) {
        List<DamageType> damageTypes = damageTypeRepository.findAll();
        int damage = 0;
        for (DamageType damageType : damageTypes) {
            damage += calculateDamage(damageType, player, enemy);
        }
        return damage;
    }

}

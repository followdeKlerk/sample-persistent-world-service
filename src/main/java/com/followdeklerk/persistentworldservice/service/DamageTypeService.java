package com.followdeklerk.persistentworldservice.service;

import com.followdeklerk.persistentworldservice.dto.DamageTypeDto;
import com.followdeklerk.persistentworldservice.entity.DamageType;
import com.followdeklerk.persistentworldservice.repository.DamageTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DamageTypeService {

    private final DamageTypeRepository damageTypeRepository;

    public DamageTypeService(DamageTypeRepository damageTypeRepository) {
        this.damageTypeRepository = damageTypeRepository;
    }

    public DamageTypeDto createDamageType(DamageTypeDto damageTypeDto) {
        DamageType damageType = new DamageType();
        damageType.setDamageType(damageTypeDto.getDamageType());
        damageType.setModifier(damageTypeDto.getModifier());
        return damageTypeRepository.save(damageType).toDto();
    }

    public DamageTypeDto updateDamageType(Long id, DamageTypeDto damageTypeDto) {
        DamageType damageType = damageTypeRepository.findById(id).orElseThrow();
        damageType.setDamageType(damageTypeDto.getDamageType());
        damageType.setModifier(damageTypeDto.getModifier());
        return damageTypeRepository.save(damageType).toDto();
    }

    public void deleteDamageType(Long id) {
        damageTypeRepository.deleteById(id);
    }

    public DamageTypeDto getDamageTypeById(Long id) {
        return damageTypeRepository.findById(id).orElseThrow().toDto();
    }

    public List<DamageTypeDto> getAllDamageTypes() {
        List<DamageType> damageTypes = damageTypeRepository.findAll();
        List<DamageTypeDto> damageTypeDtos = new ArrayList<>();
        for (DamageType damageType : damageTypes) {
            DamageTypeDto damageTypeDto = damageType.toDto();
            damageTypeDtos.add(damageTypeDto);
        }
        return damageTypeDtos;
    }
}
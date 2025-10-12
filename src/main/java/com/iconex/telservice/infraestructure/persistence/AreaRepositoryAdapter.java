/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;

import com.iconex.telservice.application.port.AreaRepositoryPort;
import com.iconex.telservice.domain.model.Area;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface AreaJpaRepository extends JpaRepository<AreaJpa, Long> {
}

@Component
public class AreaRepositoryAdapter implements AreaRepositoryPort {

    private final AreaJpaRepository jpaRepository;

    public AreaRepositoryAdapter(AreaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Area> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Area> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Area save(Area area) {
        AreaJpa jpa = mapToJpa(area);
        AreaJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private Area mapToDomain(AreaJpa jpa) {
        return new Area(jpa.getIdArea(), jpa.getNombre());
    }

    // Conversión Dominio -> JPA
    private AreaJpa mapToJpa(Area area) {
        AreaJpa jpa = new AreaJpa();
        jpa.setIdArea(area.getIdArea());
        jpa.setNombre(area.getNombre());
        return jpa;
    }
}
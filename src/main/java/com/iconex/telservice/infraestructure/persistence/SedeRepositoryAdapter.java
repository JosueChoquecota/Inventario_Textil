/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;

import com.iconex.telservice.application.port.SedeRepositoryPort;
import com.iconex.telservice.domain.model.Sede;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface SedeJpaRepository extends JpaRepository<SedeJpa, Long> {
}

@Component
public class SedeRepositoryAdapter implements SedeRepositoryPort {

    private final SedeJpaRepository jpaRepository;

    public SedeRepositoryAdapter(SedeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Sede> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Sede> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Sede save(Sede sede) {
        SedeJpa jpa = mapToJpa(sede);
        SedeJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private Sede mapToDomain(SedeJpa jpa) {
        return new Sede(jpa.getIdSede(), jpa.getNombre());
    }

    // Conversión Dominio -> JPA
    private SedeJpa mapToJpa(Sede sede) {
        SedeJpa jpa = new SedeJpa();
        jpa.setIdSede(sede.getIdSede());
        jpa.setNombre(sede.getNombre());
        return jpa;
    }
}
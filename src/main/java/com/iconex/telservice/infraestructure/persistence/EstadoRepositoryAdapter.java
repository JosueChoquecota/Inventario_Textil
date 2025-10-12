/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;


import com.iconex.telservice.application.port.EstadoRepositoryPort;
import com.iconex.telservice.domain.model.Estado;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface EstadoJpaRepository extends JpaRepository<EstadoJpa, Long> {
}

@Component
public class EstadoRepositoryAdapter implements EstadoRepositoryPort {

    private final EstadoJpaRepository jpaRepository;

    public EstadoRepositoryAdapter(EstadoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Estado> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Estado> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Estado save(Estado estado) {
        EstadoJpa jpa = mapToJpa(estado);
        EstadoJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private Estado mapToDomain(EstadoJpa jpa) {
        return new Estado(jpa.getIdEstado(), jpa.getNombre());
    }

    // Conversión Dominio -> JPA
    private EstadoJpa mapToJpa(Estado estado) {
        EstadoJpa jpa = new EstadoJpa();
        jpa.setIdEstado(estado.getIdEstado());
        jpa.setNombre(estado.getNombre());
        return jpa;
    }
}
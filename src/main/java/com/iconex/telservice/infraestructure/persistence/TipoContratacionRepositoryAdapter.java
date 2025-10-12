/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;


import com.iconex.telservice.application.port.TipoContratacionRepositoryPort;
import com.iconex.telservice.domain.model.TipoContratacion;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface TipoContratacionJpaRepository extends JpaRepository<TipoContratacionJpa, Long> {
}

@Component
public class TipoContratacionRepositoryAdapter implements TipoContratacionRepositoryPort {

    private final TipoContratacionJpaRepository jpaRepository;

    public TipoContratacionRepositoryAdapter(TipoContratacionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<TipoContratacion> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoContratacion> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public TipoContratacion save(TipoContratacion tipoContratacion) {
        TipoContratacionJpa jpa = mapToJpa(tipoContratacion);
        TipoContratacionJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private TipoContratacion mapToDomain(TipoContratacionJpa jpa) {
        return new TipoContratacion(jpa.getIdTipoContratacion(), jpa.getNombre());
    }

    // Conversión Dominio -> JPA
    private TipoContratacionJpa mapToJpa(TipoContratacion tipoContratacion) {
        TipoContratacionJpa jpa = new TipoContratacionJpa();
        jpa.setIdTipoContratacion(tipoContratacion.getIdTipoContratacion());
        jpa.setNombre(tipoContratacion.getNombre());
        return jpa;
    }
}
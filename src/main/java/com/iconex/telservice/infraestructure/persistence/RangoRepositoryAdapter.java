/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;


import com.iconex.telservice.application.port.RangoRepositoryPort;
import com.iconex.telservice.domain.model.Rango;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface RangoJpaRepository extends JpaRepository<RangoJpa, Long> {
}

@Component
public class RangoRepositoryAdapter implements RangoRepositoryPort {

    private final RangoJpaRepository jpaRepository;

    public RangoRepositoryAdapter(RangoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Rango> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Rango> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Rango save(Rango rango) {
        RangoJpa jpa = mapToJpa(rango);
        RangoJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }
    

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private Rango mapToDomain(RangoJpa jpa) {
        return new Rango(jpa.getIdRango(), jpa.getNombre(), jpa.getFoto());
    }

    // Conversión Dominio -> JPA
    private RangoJpa mapToJpa(Rango rango) {
        RangoJpa jpa = new RangoJpa();
        jpa.setIdRango(rango.getIdRango());
        jpa.setNombre(rango.getNombre());
        jpa.setFoto(rango.getFoto());
        return jpa;
    }
}
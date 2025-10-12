/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;


import com.iconex.telservice.application.port.RolRepositoryPort;
import com.iconex.telservice.domain.model.Rol;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface RolJpaRepository extends JpaRepository<RolJpa, Long> {
}

@Component
public class RolRepositoryAdapter implements RolRepositoryPort {

    private final RolJpaRepository jpaRepository;

    public RolRepositoryAdapter(RolJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Rol> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Rol save(Rol rol) {
        RolJpa jpa = mapToJpa(rol);
        RolJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private Rol mapToDomain(RolJpa jpa) {
        return new Rol(jpa.getIdRol(), jpa.getNombre());
    }

    // Conversión Dominio -> JPA
    private RolJpa mapToJpa(Rol rol) {
        RolJpa jpa = new RolJpa();
        jpa.setIdRol(rol.getIdRol());
        jpa.setNombre(rol.getNombre());
        return jpa;
    }
}
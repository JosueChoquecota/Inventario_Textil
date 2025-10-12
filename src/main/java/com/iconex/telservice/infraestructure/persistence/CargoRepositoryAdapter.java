/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.infraestructure.persistence;

import com.iconex.telservice.application.port.AreaRepositoryPort;
import com.iconex.telservice.application.port.CargoRepositoryPort;
import com.iconex.telservice.domain.model.Area;
import com.iconex.telservice.domain.model.Cargo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



interface CargoJpaRepository extends JpaRepository<CargoJpa, Long> {
}

@Component
public class CargoRepositoryAdapter implements CargoRepositoryPort {

    private final CargoJpaRepository jpaRepository;

    public CargoRepositoryAdapter(CargoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Cargo> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Cargo save(Cargo cargo) {
        CargoJpa jpa = mapToJpa(cargo);
        CargoJpa saved = jpaRepository.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversión JPA -> Dominio
    private Cargo mapToDomain(CargoJpa jpa) {
        return new Cargo(jpa.getIdCargo(), jpa.getNombre());
    }

    // Conversión Dominio -> JPA
    private CargoJpa mapToJpa(Cargo cargo) {
        CargoJpa jpa = new CargoJpa();
        jpa.setIdCargo(cargo.getIdCargo());
        jpa.setNombre(cargo.getNombre());
        return jpa;
    }
}
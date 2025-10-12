/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;

import com.iconex.telservice.domain.model.Cargo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface CargoRepositoryPort {

    // Listar todas las áreas
    List<Cargo> findAll();

    // Buscar área por ID
    Optional<Cargo> findById(Long id);

    // Guardar un área (crear o actualizar)
    Cargo save(Cargo cargo);

    // Eliminar un área por ID
    void deleteById(Long id);
}

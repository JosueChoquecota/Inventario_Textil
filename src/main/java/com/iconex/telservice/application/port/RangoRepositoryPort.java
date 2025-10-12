/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;

import com.iconex.telservice.domain.model.Cargo;
import com.iconex.telservice.domain.model.Rango;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface RangoRepositoryPort {

    // Listar todas las áreas
    List<Rango> findAll();

    // Buscar área por ID
    Optional<Rango> findById(Long id);

    // Guardar un área (crear o actualizar)
    Rango save(Rango rango);

    // Eliminar un área por ID
    void deleteById(Long id);
}

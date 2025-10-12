/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;

import com.iconex.telservice.domain.model.Area;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface AreaRepositoryPort {

    // Listar todas las áreas
    List<Area> findAll();

    // Buscar área por ID
    Optional<Area> findById(Long id);

    // Guardar un área (crear o actualizar)
    Area save(Area area);

    // Eliminar un área por ID
    void deleteById(Long id);
}

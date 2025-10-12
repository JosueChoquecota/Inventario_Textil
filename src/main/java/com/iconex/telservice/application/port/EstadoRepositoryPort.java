/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;

import com.iconex.telservice.domain.model.Estado;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface EstadoRepositoryPort {

    // Listar todos los estados
    List<Estado> findAll();

    // Buscar estado por ID
    Optional<Estado> findById(Long id);

    // Guardar un estado (crear o actualizar)
    Estado save(Estado estado);

    // Eliminar un estado por ID
    void deleteById(Long id);
}

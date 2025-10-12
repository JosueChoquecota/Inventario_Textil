/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;


import com.iconex.telservice.domain.model.Sede;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface SedeRepositoryPort {

    // Listar todas las áreas
    List<Sede> findAll();

    // Buscar área por ID
    Optional<Sede> findById(Long id);

    // Guardar un área (crear o actualizar)
    Sede save(Sede sede);

    // Eliminar un área por ID
    void deleteById(Long id);
}

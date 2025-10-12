/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;


import com.iconex.telservice.domain.model.Rol;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface RolRepositoryPort {

    // Listar todas las áreas
    List<Rol> findAll();

    // Buscar área por ID
    Optional<Rol> findById(Long id);

    // Guardar un área (crear o actualizar)
    Rol save(Rol rol);

    // Eliminar un área por ID
    void deleteById(Long id);
}

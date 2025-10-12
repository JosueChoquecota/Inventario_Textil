/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;



import com.iconex.telservice.domain.model.TipoContratacion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diseño
 */
public interface TipoContratacionRepositoryPort {

    // Listar todas las áreas
    List<TipoContratacion> findAll();

    // Buscar área por ID
    Optional<TipoContratacion> findById(Long id);

    // Guardar un área (crear o actualizar)
    TipoContratacion save(TipoContratacion tipoContratacion);

    // Eliminar un área por ID
    void deleteById(Long id);
}

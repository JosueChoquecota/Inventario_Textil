/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;

import com.iconex.telservice.domain.model.Producto;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de repositorio para Producto.
 * Define los métodos que la capa de aplicación necesita
 * sin depender de la implementación concreta.
 */

public interface ProductoRepositoryPort {
    Producto save(Producto producto);           // Crear o actualizar
    Optional<Producto> findById(Long id);       // Buscar por ID
    List<Producto> findAll();                   // Listar todos
    void deleteById(Long id);                   // Borrar por ID
}

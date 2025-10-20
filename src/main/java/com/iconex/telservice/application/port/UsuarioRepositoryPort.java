/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.port;

import com.iconex.telservice.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de repositorio para Producto.
 * Define los métodos que la capa de aplicación necesita
 * sin depender de la implementación concreta.
 */

public interface UsuarioRepositoryPort {
        Usuario save(Usuario usuario);           // Crear o actualizar
        Optional<Usuario> findById(Long id);       // Buscar por ID
        Optional<Usuario> findByDni(String dni);      // Buscar por Dni
        Optional<Usuario> findByCorreo(String correo); 
        Optional<Usuario> findByCorreoConRol(String correo);// Buscar por Correo con rol
        List<Usuario> findAll();                   // Listar todos
        void deleteById(Long id);                   // Borrar por ID

    
    List<Usuario> findAllPaginated(int page, int size, String search);
    long countAllFiltered(String search);
}

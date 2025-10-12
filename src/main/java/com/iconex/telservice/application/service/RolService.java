/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;
import com.iconex.telservice.application.port.RolRepositoryPort;
import com.iconex.telservice.domain.model.Rol;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class RolService {

    private final RolRepositoryPort rolRepository;

    public RolService(RolRepositoryPort rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }
    
    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado con id: " + id));
    }
}


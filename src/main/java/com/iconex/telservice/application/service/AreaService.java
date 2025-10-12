/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;

import com.iconex.telservice.application.port.AreaRepositoryPort;
import com.iconex.telservice.domain.model.Area;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class AreaService {

    private final AreaRepositoryPort areaRepository;

    public AreaService(AreaRepositoryPort areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> listarAreas() {
        return areaRepository.findAll();
    }
    
    public Area buscarPorId(Long id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Área no encontrada con id: " + id));
    }
}

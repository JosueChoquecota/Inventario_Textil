/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;
import com.iconex.telservice.application.port.EstadoRepositoryPort;
import com.iconex.telservice.domain.model.Estado;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class EstadoService {

    private final EstadoRepositoryPort estadoRepository;

    public EstadoService(EstadoRepositoryPort estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }
    
    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Área no encontrada con id: " + id));
    }
}
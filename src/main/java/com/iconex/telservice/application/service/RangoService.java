/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;
import com.iconex.telservice.application.port.RangoRepositoryPort;
import com.iconex.telservice.domain.model.Rango;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class RangoService {

    private final RangoRepositoryPort rangoRepository;

    public RangoService(RangoRepositoryPort rangoRepository) {
        this.rangoRepository = rangoRepository;
    }

    public List<Rango> listarRangos() {
        return rangoRepository.findAll();
    }
    
    public Rango buscarPorId(Long id) {
        return rangoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rango no encontrado con id: " + id));
    }
}


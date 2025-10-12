/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;
import com.iconex.telservice.application.port.SedeRepositoryPort;
import com.iconex.telservice.domain.model.Sede;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class SedeService {

    private final SedeRepositoryPort sedeRepository;

    public SedeService(SedeRepositoryPort sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public List<Sede> listarSedes() {
        return sedeRepository.findAll();
    }
    
    public Sede buscarPorId(Long id) {
        return sedeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sede no encontrado con id: " + id));
    }
}



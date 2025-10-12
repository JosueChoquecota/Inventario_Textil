/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;

import com.iconex.telservice.application.port.TipoContratacionRepositoryPort;
import com.iconex.telservice.domain.model.TipoContratacion;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class TipoContratacionService {

    private final TipoContratacionRepositoryPort tipoContratacionRepository;

    public TipoContratacionService(TipoContratacionRepositoryPort tipoContratacionRepository) {
        this.tipoContratacionRepository = tipoContratacionRepository;
    }

    public List<TipoContratacion> listarTipoContrataciones() {
        return tipoContratacionRepository.findAll();
    }
    
    public TipoContratacion buscarPorId(Long id) {
        return tipoContratacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TipoContratacion no encontrado con id: " + id));
    }
}



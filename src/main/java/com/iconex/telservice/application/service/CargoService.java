/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;
import com.iconex.telservice.application.port.CargoRepositoryPort;
import com.iconex.telservice.domain.model.Cargo;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diseño
 */
@Service
public class CargoService {

    private final CargoRepositoryPort cargoRepository;

    public CargoService(CargoRepositoryPort cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }
    
    public Cargo buscarPorId(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cargo no encontrado con id: " + id));
    }
}

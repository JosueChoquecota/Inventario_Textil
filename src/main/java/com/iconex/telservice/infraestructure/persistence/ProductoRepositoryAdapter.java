/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.persistence;

import com.iconex.telservice.application.port.ProductoRepositoryPort;
import com.iconex.telservice.domain.model.Producto;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Spring Data Repository para JPA
interface ProductoJpaRepository extends JpaRepository<ProductoJpa, Long> {
}

// Adaptador que implementa el puerto del dominio
@Component

public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoJpaRepository repo;

    public ProductoRepositoryAdapter(ProductoJpaRepository repo) {
        this.repo = repo;
    }
 // ---- Convertidores ----
    private Producto mapToDomain(ProductoJpa jpa) {
        return new Producto(
            jpa.getId(),
            jpa.getNombre(),
            java.math.BigDecimal.valueOf(jpa.getPrecio()),
            jpa.getStock()
        );
    }

    private ProductoJpa mapToJpa(Producto producto) {
        ProductoJpa jpa = new ProductoJpa();
        jpa.setId(producto.getId());
        jpa.setNombre(producto.getNombre());
        jpa.setPrecio(producto.getPrecio().doubleValue());
        jpa.setStock(producto.getStock());
        return jpa;
    }

    // ---- Implementación del puerto ----
    @Override
    public Producto save(Producto producto) {
        ProductoJpa jpa = mapToJpa(producto);
        ProductoJpa saved = repo.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repo.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<Producto> findAll() {
        return repo.findAll().stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}


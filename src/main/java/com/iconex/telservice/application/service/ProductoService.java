/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;

import com.iconex.telservice.application.port.ProductoRepositoryPort;
import com.iconex.telservice.domain.model.Producto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Servicio de aplicación para manejar Productos. Expone métodos que serán
 * llamados por controladores o WebSockets.
 */
@Service
public class ProductoService {

    private final ProductoRepositoryPort repo;
    private final SimpMessagingTemplate messagingTemplate; // <--- WebSocket

    public ProductoService(ProductoRepositoryPort repo,SimpMessagingTemplate messagingTemplate){
        this.repo = repo;
        this.messagingTemplate = messagingTemplate;
    }
    
    //Crear un nuevo producto
    public Producto crearProducto(String nombre, double precio, int stock) {
        Producto p = new Producto(null, nombre, BigDecimal.valueOf(precio), stock);
        Producto saved = repo.save(p);
        
        // Enviar mensaje WebSocket
        messagingTemplate.convertAndSend("/topic/productos", saved);

        return saved;
    }

    //Listar todos los productos
    public List<Producto> listarProductos() {
        return repo.findAll();
    }

    //Actualizar stock de un producto existente
    public void actualizarStock(Long id, int cantidad) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        p.actualizarStock(cantidad);
        
        Producto updated = repo.save(p);

        // Enviar mensaje WebSocket
        messagingTemplate.convertAndSend("/topic/productos", updated);
    }
    
    // Editar producto existente (nombre, precio, stock)
    public Producto editarProducto(Long id, String nombre, double precio, int stock) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        p.setNombre(nombre);
        p.setPrecio(BigDecimal.valueOf(precio));
        p.setStock(stock);

        Producto updated = repo.save(p);

        // Enviar mensaje WebSocket
        messagingTemplate.convertAndSend("/topic/productos", updated);

        return updated;
    }
    
    // Borrar producto por ID
    public void eliminarProducto(Long id) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        repo.deleteById(id);

        // Enviar mensaje WebSocket indicando que fue eliminado
        Map<String, Object> msg = new HashMap<>();
        msg.put("id", id);
        msg.put("eliminado", true);

        messagingTemplate.convertAndSend("/topic/productos", msg);
    }

}

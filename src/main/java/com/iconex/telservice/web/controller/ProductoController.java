/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.web.controller;

import com.iconex.telservice.application.service.ProductoService;
import com.iconex.telservice.domain.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // Página principal: lista de productos
    @GetMapping
    public String listar(Model model) {
        List<Producto> productos = service.listarProductos();
        model.addAttribute("productos", productos);
        return "productos"; // plantilla Thymeleaf
    }

    // Crear nuevo producto
    @PostMapping("/crear")
    public String crear(@RequestParam String nombre,
                        @RequestParam double precio,
                        @RequestParam int stock) {
        service.crearProducto(nombre, precio, stock);
        return "redirect:/productos";
    }

    // Editar producto (llamado desde fetch PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editarProducto(
            @PathVariable Long id,
            @RequestBody Map<String, Object> payload) {

        String nombre = (String) payload.get("nombre");
        double precio = Double.parseDouble(payload.get("precio").toString());
        int stock = Integer.parseInt(payload.get("stock").toString());

        Producto updated = service.editarProducto(id, nombre, precio, stock);
        return ResponseEntity.ok(updated);
    }

    // Borrar producto (llamado desde fetch DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}


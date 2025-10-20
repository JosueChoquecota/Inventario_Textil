/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconex.telservice.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author User
 */
@Controller
public class ProveedorController {  
    @GetMapping("/proveedores")
    public String mostrarProveedores() {
        // CAMBIO 2: El nombre de la plantilla ahora es "inventario" en minúsculas.
        // Spring buscará "templates/inventario.html"
        return "proveedores"; 
    }   
}

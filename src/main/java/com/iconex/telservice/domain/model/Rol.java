/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
public class Rol {
    private final Long idRol;
    private String nombre;

    public Rol(Long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdRol() {
        return idRol;
    }


    
    
}

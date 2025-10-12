/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
public class Estado {

    private final Long idEstado;
    private String nombre;

    public Estado(Long idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdEstado() {
        return idEstado;
    }

  
   

    
}

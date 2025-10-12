/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
public class Area {

    private final Long idArea;
    private String nombre;

    public Area(Long idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdArea() {
        return idArea;
    }

  
    

}

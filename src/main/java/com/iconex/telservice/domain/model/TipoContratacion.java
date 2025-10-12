/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
public class TipoContratacion {
    
    private final Long idTipoContratacion;
    private String nombre;

    public TipoContratacion(Long idTipoContratacion, String nombre) {
        this.idTipoContratacion = idTipoContratacion;
        this.nombre = nombre;
    }

    public Long getIdTipoContratacion() {
        return idTipoContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
}

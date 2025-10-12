/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

import java.time.LocalDate;

/**
 *
 * @author Diseño
 */
class Campaña {
    private final long id_Campaña;
    private String nombre;
    private String detalle;
    private String aplica;
    private LocalDate lanzamiento;
    private LocalDate fecha_fin;

    public Campaña(long id_Campaña, String nombre, String detalle, String aplica, LocalDate lanzamiento, LocalDate fecha_fin) {
        this.id_Campaña = id_Campaña;
        this.nombre = nombre;
        this.detalle = detalle;
        this.aplica = aplica;
        this.lanzamiento = lanzamiento;
        this.fecha_fin = fecha_fin;
    }

    public long getId_Campaña() {
        return id_Campaña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getAplica() {
        return aplica;
    }

    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    public LocalDate getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(LocalDate lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

  
    
}

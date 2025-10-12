/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
class Plan {
    
    private final Long idPlan;
    private String nombre;
    private TipoServicio tipoServicio;
    private double costo;
    private String megas;
    private String descripcion;

    public Plan(Long idPlan, String nombre, TipoServicio tipoServicio, double costo, String megas, String descripcion) {
        this.idPlan = idPlan;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.costo = costo;
        this.megas = megas;
        this.descripcion = descripcion;
    }

    public Long getIdPlan() {
        return idPlan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getMegas() {
        return megas;
    }

    public void setMegas(String megas) {
        this.megas = megas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

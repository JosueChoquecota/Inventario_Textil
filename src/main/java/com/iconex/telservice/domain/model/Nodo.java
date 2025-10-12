/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
class Nodo {
    
    private final Long idNodo;
    private String nombreNodo;
    private Zona zona;
    private String contrasena;
    private int canal;
    private int vlan;
    private String ubicacion;

    public Nodo(Long idNodo, String nombreNodo, Zona zona, String contrasena, int canal, int vlan, String ubicacion) {
        this.idNodo = idNodo;
        this.nombreNodo = nombreNodo;
        this.zona = zona;
        this.contrasena = contrasena;
        this.canal = canal;
        this.vlan = vlan;
        this.ubicacion = ubicacion;
    }

    public Long getIdNodo() {
        return idNodo;
    }

    public String getNombreNodo() {
        return nombreNodo;
    }

    public void setNombreNodo(String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getVlan() {
        return vlan;
    }

    public void setVlan(int vlan) {
        this.vlan = vlan;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}

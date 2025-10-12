/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
class Direccion {
    
    private final Long idDireccion;
    private boolean propiaAlquilada;
    private boolean casaDepartamento;
    private String direccion;
    private String nPiso;
    private String habitacion;
    private String distrito;
    private String foto;
    private String dniA;
    private String dniB;
    private String documentacion;

    public Direccion(Long idDireccion, boolean propiaAlquilada, boolean casaDepartamento, String direccion, String nPiso, String habitacion, String distrito, String foto, String dniA, String dniB, String documentacion) {
        this.idDireccion = idDireccion;
        this.propiaAlquilada = propiaAlquilada;
        this.casaDepartamento = casaDepartamento;
        this.direccion = direccion;
        this.nPiso = nPiso;
        this.habitacion = habitacion;
        this.distrito = distrito;
        this.foto = foto;
        this.dniA = dniA;
        this.dniB = dniB;
        this.documentacion = documentacion;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public boolean isPropiaAlquilada() {
        return propiaAlquilada;
    }

    public void setPropiaAlquilada(boolean propiaAlquilada) {
        this.propiaAlquilada = propiaAlquilada;
    }

    public boolean isCasaDepartamento() {
        return casaDepartamento;
    }

    public void setCasaDepartamento(boolean casaDepartamento) {
        this.casaDepartamento = casaDepartamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getnPiso() {
        return nPiso;
    }

    public void setnPiso(String nPiso) {
        this.nPiso = nPiso;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDniA() {
        return dniA;
    }

    public void setDniA(String dniA) {
        this.dniA = dniA;
    }

    public String getDniB() {
        return dniB;
    }

    public void setDniB(String dniB) {
        this.dniB = dniB;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    
    
    
    
}

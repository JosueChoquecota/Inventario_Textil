/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
class Empresa {
    
    private final Long idEmpresa;
    private String ruc;
    private String razonSocial;
    private String nombreComercial;
    private String direccionLegal;
    private String foto;

    public Empresa(Long idEmpresa, String ruc, String razonSocial, String nombreComercial, String direccionLegal, String foto) {
        this.idEmpresa = idEmpresa;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.direccionLegal = direccionLegal;
        this.foto = foto;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccionLegal() {
        return direccionLegal;
    }

    public void setDireccionLegal(String direccionLegal) {
        this.direccionLegal = direccionLegal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
}

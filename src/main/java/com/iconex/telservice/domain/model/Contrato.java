/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
class Contrato {
    
    private final Long idContrato;
    private String numeroContrato;
    private String descripcion;
    private String foto;
    private Empresa empresa;

    public Contrato(Long idContrato, String numeroContrato, String descripcion, String foto, Empresa empresa) {
        this.idContrato = idContrato;
        this.numeroContrato = numeroContrato;
        this.descripcion = descripcion;
        this.foto = foto;
        this.empresa = empresa;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    }

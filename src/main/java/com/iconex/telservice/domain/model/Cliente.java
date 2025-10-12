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
public class Cliente {
    
    private final Long idCliente;
    private TipoDocumento tipoDocumento;
    private String nDocumento;
    private String nombreCliente;
    private Direccion direccion;
    private Contrato contrato;
    private Nodo nodo;
    private String correo;
    private String contrasena;
    private String ubicacion;
    private int puerto;
    private String observacion;
    private String estado;

    public Cliente(Long idCliente, TipoDocumento tipoDocumento, String nDocumento, String nombreCliente, Direccion direccion, Contrato contrato, Nodo nodo, String correo, String contrasena, String ubicacion, int puerto, String observacion, String estado) {
        this.idCliente = idCliente;
        this.tipoDocumento = tipoDocumento;
        this.nDocumento = nDocumento;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.contrato = contrato;
        this.nodo = nodo;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ubicacion = ubicacion;
        this.puerto = puerto;
        this.observacion = observacion;
        this.estado = estado;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getnDocumento() {
        return nDocumento;
    }

    public void setnDocumento(String nDocumento) {
        this.nDocumento = nDocumento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   }
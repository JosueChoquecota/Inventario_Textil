/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;

/**
 *
 * @author Diseño
 */
import java.time.LocalDate;
import java.util.Date;

public class Usuario {

    private Long idUsuario;
    private String correo;
    private String contrasena;
    private String dni;
    private String nombre;
    private Area area;
    private Cargo cargo;
    private Estado estado;
    private Rol rol;
    private Rango rango;
    private Sede sede;
    private LocalDate fechaInicio;
    private TipoContratacion tipoContratacion;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String correo, String contrasena, String dni, String nombre, Area area, Cargo cargo, Estado estado, Rol rol, Rango rango, Sede sede, LocalDate fechaInicio, TipoContratacion tipoContratacion) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.dni = dni;
        this.nombre = nombre;
        this.area = area;
        this.cargo = cargo;
        this.estado = estado;
        this.rol = rol;
        this.rango = rango;
        this.sede = sede;
        this.fechaInicio = fechaInicio;
        this.tipoContratacion = tipoContratacion;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Long getIdUsuario() {
        return idUsuario;
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
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }


    public TipoContratacion getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(TipoContratacion tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

  
 
}


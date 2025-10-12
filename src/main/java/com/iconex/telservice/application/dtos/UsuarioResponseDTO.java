/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.dtos;

import com.iconex.telservice.domain.model.Area;
import com.iconex.telservice.domain.model.Cargo;
import com.iconex.telservice.domain.model.Estado;
import com.iconex.telservice.domain.model.Rango;
import com.iconex.telservice.domain.model.Rol;
import com.iconex.telservice.domain.model.Sede;
import com.iconex.telservice.domain.model.TipoContratacion;
import java.time.LocalDate;

/**
 *
 * @author Diseño
 */
public class UsuarioResponseDTO {

    private Long idUsuario;
    private String correo;
    private String dni;
    private String nombre;
    private String areaNombre;
    private String cargoNombre;
    private String rolNombre;
    private String rangoNombre;
    private String sedeNombre;
    private String estadoNombre;
    private LocalDate fechaInicio;
    private String tipoContratacionNombre;

    // IDs para edición
    private Long areaId;
    private Long cargoId;
    private Long rolId;
    private Long rangoId;
    private Long sedeId;
    private Long estadoId;
    private Long tipoContratacionId;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long idUsuario, String correo, String dni, String nombre, String areaNombre, String cargoNombre, String rolNombre, String rangoNombre, String sedeNombre, String estadoNombre, LocalDate fechaInicio, String tipoContratacionNombre) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.dni = dni;
        this.nombre = nombre;
        this.areaNombre = areaNombre;
        this.cargoNombre = cargoNombre;
        this.rolNombre = rolNombre;
        this.rangoNombre = rangoNombre;
        this.sedeNombre = sedeNombre;
        this.estadoNombre = estadoNombre;
        this.fechaInicio = fechaInicio;
        this.tipoContratacionNombre = tipoContratacionNombre;
    }

    
    

    // getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    public String getCargoNombre() {
        return cargoNombre;
    }

    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRangoNombre() {
        return rangoNombre;
    }

    public void setRangoNombre(String rangoNombre) {
        this.rangoNombre = rangoNombre;
    }

    public String getSedeNombre() {
        return sedeNombre;
    }

    public void setSedeNombre(String sedeNombre) {
        this.sedeNombre = sedeNombre;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoContratacionNombre() {
        return tipoContratacionNombre;
    }

    public void setTipoContratacionNombre(String tipoContratacionNombre) {
        this.tipoContratacionNombre = tipoContratacionNombre;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public Long getRangoId() {
        return rangoId;
    }

    public void setRangoId(Long rangoId) {
        this.rangoId = rangoId;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Long getTipoContratacionId() {
        return tipoContratacionId;
    }

    public void setTipoContratacionId(Long tipoContratacionId) {
        this.tipoContratacionId = tipoContratacionId;
    }
    
    
}


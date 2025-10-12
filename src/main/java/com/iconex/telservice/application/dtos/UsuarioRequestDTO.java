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

public class UsuarioRequestDTO {

    private Long idUsuario;
    private String correo;
    private String contrasena;
    private String dni;
    private String nombre;
    private Long estadoId;
    private Long areaId;
    private Long cargoId;
    private Long rolId;
    private Long rangoId;
    private Long sedeId;
    private LocalDate fechaInicio;
    private Long tipoContratacionId;

    public UsuarioRequestDTO() {}

    // getters y setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }

    public Long getCargoId() { return cargoId; }
    public void setCargoId(Long cargoId) { this.cargoId = cargoId; }

    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }

    public Long getRangoId() { return rangoId; }
    public void setRangoId(Long rangoId) { this.rangoId = rangoId; }

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }





    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public Long getTipoContratacionId() { return tipoContratacionId; }
    public void setTipoContratacionId(Long tipoContratacionId) { this.tipoContratacionId = tipoContratacionId; }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.persistence;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class UsuarioJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    // Relaciones con fetch LAZY para evitar cargar todo automáticamente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", nullable = false)
    private AreaJpa area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargoJpa cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoJpa estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolJpa rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rango", nullable = false)
    private RangoJpa rango;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede", nullable = false)
    private SedeJpa sede;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_contratacion", nullable = false)
    private TipoContratacionJpa tipoContratacion;

    // Getters y Setters
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

    public AreaJpa getArea() { return area; }
    public void setArea(AreaJpa area) { this.area = area; }

    public CargoJpa getCargo() { return cargo; }
    public void setCargo(CargoJpa cargo) { this.cargo = cargo; }

    public EstadoJpa getEstado() { return estado; }
    public void setEstado(EstadoJpa estado) { this.estado = estado; }

    public RolJpa getRol() { return rol; }
    public void setRol(RolJpa rol) { this.rol = rol; }

    public RangoJpa getRango() { return rango; }
    public void setRango(RangoJpa rango) { this.rango = rango; }

    public SedeJpa getSede() { return sede; }
    public void setSede(SedeJpa sede) { this.sede = sede; }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public TipoContratacionJpa getTipoContratacion() { return tipoContratacion; }
    public void setTipoContratacion(TipoContratacionJpa tipoContratacion) { this.tipoContratacion = tipoContratacion; }

}
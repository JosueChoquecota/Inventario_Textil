/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_contratacion")
public class TipoContratacionJpa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contratacion")
    private Long idTipoContratacion;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    public Long getIdTipoContratacion() {
        return idTipoContratacion;
    }

    public void setIdTipoContratacion(Long idTipoContratacion) {
        this.idTipoContratacion = idTipoContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
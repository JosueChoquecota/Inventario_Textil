/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "rangos")
public class RangoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rango")
    private Long idRango;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "foto")
    private String foto;

    public Long getIdRango() {
        return idRango;
    }

    public void setIdRango(Long idRango) {
        this.idRango = idRango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

  

}

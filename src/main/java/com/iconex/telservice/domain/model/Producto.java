/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.domain.model;
import java.math.BigDecimal;

/**
 *
 * @author Diseño
 */
public class Producto {
    private final Long id;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    
   public Producto(Long id,String nombre, BigDecimal precio, int stock){
       this.id=id;
       this.nombre=nombre;
       this.precio=precio;
       this.stock=stock;
   }
   
   // Lógica de dominio: actualizar stock
   public void actualizarStock(int cantidad){
       if (cantidad < 0 && Math.abs(cantidad)>stock){
           throw new IllegalArgumentException("No hay suficiente Stock");
           
       }
       this.stock = cantidad;
   }

    public Long getId() {
        return id;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
   
}

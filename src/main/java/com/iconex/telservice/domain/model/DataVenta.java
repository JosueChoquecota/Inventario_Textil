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
public class DataVenta {
    
    private final Long idCliente;
    private TipoServicio tipoServicio;
    private Plan plan;
    private Campaña campaña;
    private boolean tipoFacturacion;
    private boolean pago;
    private LocalDate fechaPago;
    private boolean comision;

    public DataVenta(Long idCliente, TipoServicio tipoServicio, Plan plan, Campaña campaña, boolean tipoFacturacion, boolean pago, LocalDate fechaPago, boolean comision) {
        this.idCliente = idCliente;
        this.tipoServicio = tipoServicio;
        this.plan = plan;
        this.campaña = campaña;
        this.tipoFacturacion = tipoFacturacion;
        this.pago = pago;
        this.fechaPago = fechaPago;
        this.comision = comision;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Campaña getCampaña() {
        return campaña;
    }

    public void setCampaña(Campaña campaña) {
        this.campaña = campaña;
    }

    public boolean isTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(boolean tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public boolean isComision() {
        return comision;
    }

    public void setComision(boolean comision) {
        this.comision = comision;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class ServiciosDTO {
    
    private Integer idServicio;
    private String folio;
    private String fechaSolicitud;
    private String fechaRealizacion;
    private String tipoCamion;
    private String placasCamion;
    private String tipoCarga;
    private String ciudadOrigen;
    private String ciudadDestino;
    private Integer subTotal;
    private Integer iva;
    private Integer isr;
    private Integer totalCobrado;
    private Integer utilidadNeta;
    private ClienteDTO idCliente;
//    private Trabajador idTrabajador;
//    private List<CostoServicioDTO> costoServicioList;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    public String getPlacasCamion() {
        return placasCamion;
    }

    public void setPlacasCamion(String placasCamion) {
        this.placasCamion = placasCamion;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getIsr() {
        return isr;
    }

    public void setIsr(Integer isr) {
        this.isr = isr;
    }

    public Integer getTotalCobrado() {
        return totalCobrado;
    }

    public void setTotalCobrado(Integer totalCobrado) {
        this.totalCobrado = totalCobrado;
    }

    public Integer getUtilidadNeta() {
        return utilidadNeta;
    }

    public void setUtilidadNeta(Integer utilidadNeta) {
        this.utilidadNeta = utilidadNeta;
    }

    public ClienteDTO getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteDTO idCliente) {
        this.idCliente = idCliente;
    }
    
    
}

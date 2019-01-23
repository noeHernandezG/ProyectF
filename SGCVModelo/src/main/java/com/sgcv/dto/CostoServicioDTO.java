/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dto;

/**
 *
 * @author Ernesto
 */
public class CostoServicioDTO {
    
    private Integer idCosto;
    private Integer kilometrajeInicial;
    private Integer kilometrajeFinal;
    private Integer litrosGastados;
    private String calculoRendimiento;
    private Integer dieselCargado;
    private Integer casetas;
    private Integer comision;
    private Integer viaticos;
    private Integer refacciones;
    private Integer otros;

    public Integer getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(Integer idCosto) {
        this.idCosto = idCosto;
    }

    public Integer getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public void setKilometrajeInicial(Integer kilometrajeInicial) {
        this.kilometrajeInicial = kilometrajeInicial;
    }

    public Integer getKilometrajeFinal() {
        return kilometrajeFinal;
    }

    public void setKilometrajeFinal(Integer kilometrajeFinal) {
        this.kilometrajeFinal = kilometrajeFinal;
    }

    public Integer getLitrosGastados() {
        return litrosGastados;
    }

    public void setLitrosGastados(Integer litrosGastados) {
        this.litrosGastados = litrosGastados;
    }

    public String getCalculoRendimiento() {
        return calculoRendimiento;
    }

    public void setCalculoRendimiento(String calculoRendimiento) {
        this.calculoRendimiento = calculoRendimiento;
    }

    public Integer getDieselCargado() {
        return dieselCargado;
    }

    public void setDieselCargado(Integer dieselCargado) {
        this.dieselCargado = dieselCargado;
    }

    public Integer getCasetas() {
        return casetas;
    }

    public void setCasetas(Integer casetas) {
        this.casetas = casetas;
    }

    public Integer getComision() {
        return comision;
    }

    public void setComision(Integer comision) {
        this.comision = comision;
    }

    public Integer getViaticos() {
        return viaticos;
    }

    public void setViaticos(Integer viaticos) {
        this.viaticos = viaticos;
    }

    public Integer getRefacciones() {
        return refacciones;
    }

    public void setRefacciones(Integer refacciones) {
        this.refacciones = refacciones;
    }

    public Integer getOtros() {
        return otros;
    }

    public void setOtros(Integer otros) {
        this.otros = otros;
    }
    
    
}

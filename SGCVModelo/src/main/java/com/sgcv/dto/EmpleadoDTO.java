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
public class EmpleadoDTO {
    
    private Boolean sindicalizado;
    private String tipoJornada;
    private String periodicidad;
    private String numeroEmpleado;
    private Integer idTrabajador;
    private String urlFoto;
    private String numeroLicencia;
    private String vigenciaLicencia;
    private String nssTrabajador;
    private String fechaIngreso;
    private Integer sueldo;
    private Integer sueldoIntegrado;
    private String puesto;
    private String riesgoTrabajo;
    private String tipoContrato;
    private String localidadLaboral;
    private DireccionDTO idDireccion;
    private PersonaDTO idPersona;

    public Boolean getSindicalizado() {
        return sindicalizado;
    }

    public void setSindicalizado(Boolean sindicalizado) {
        this.sindicalizado = sindicalizado;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getVigenciaLicencia() {
        return vigenciaLicencia;
    }

    public void setVigenciaLicencia(String vigenciaLicencia) {
        this.vigenciaLicencia = vigenciaLicencia;
    }

    public String getNssTrabajador() {
        return nssTrabajador;
    }

    public void setNssTrabajador(String nssTrabajador) {
        this.nssTrabajador = nssTrabajador;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getSueldoIntegrado() {
        return sueldoIntegrado;
    }

    public void setSueldoIntegrado(Integer sueldoIntegrado) {
        this.sueldoIntegrado = sueldoIntegrado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRiesgoTrabajo() {
        return riesgoTrabajo;
    }

    public void setRiesgoTrabajo(String riesgoTrabajo) {
        this.riesgoTrabajo = riesgoTrabajo;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getLocalidadLaboral() {
        return localidadLaboral;
    }

    public void setLocalidadLaboral(String localidadLaboral) {
        this.localidadLaboral = localidadLaboral;
    }

    public DireccionDTO getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(DireccionDTO idDireccion) {
        this.idDireccion = idDireccion;
    }

    public PersonaDTO getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(PersonaDTO idPersona) {
        this.idPersona = idPersona;
    }
    
}

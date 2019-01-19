/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
    , @NamedQuery(name = "Trabajador.findByIdTrabajador", query = "SELECT t FROM Trabajador t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Trabajador.findByUrlFoto", query = "SELECT t FROM Trabajador t WHERE t.urlFoto = :urlFoto")
    , @NamedQuery(name = "Trabajador.findByNumeroLicencia", query = "SELECT t FROM Trabajador t WHERE t.numeroLicencia = :numeroLicencia")
    , @NamedQuery(name = "Trabajador.findByVigenciaLicencia", query = "SELECT t FROM Trabajador t WHERE t.vigenciaLicencia = :vigenciaLicencia")
    , @NamedQuery(name = "Trabajador.findByNssTrabajador", query = "SELECT t FROM Trabajador t WHERE t.nssTrabajador = :nssTrabajador")
    , @NamedQuery(name = "Trabajador.findByFechaIngreso", query = "SELECT t FROM Trabajador t WHERE t.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Trabajador.findBySueldo", query = "SELECT t FROM Trabajador t WHERE t.sueldo = :sueldo")
    , @NamedQuery(name = "Trabajador.findBySueldoIntegrado", query = "SELECT t FROM Trabajador t WHERE t.sueldoIntegrado = :sueldoIntegrado")
    , @NamedQuery(name = "Trabajador.findByPuesto", query = "SELECT t FROM Trabajador t WHERE t.puesto = :puesto")
    , @NamedQuery(name = "Trabajador.findByRiesgoTrabajo", query = "SELECT t FROM Trabajador t WHERE t.riesgoTrabajo = :riesgoTrabajo")
    , @NamedQuery(name = "Trabajador.findByTipoContrato", query = "SELECT t FROM Trabajador t WHERE t.tipoContrato = :tipoContrato")
    , @NamedQuery(name = "Trabajador.findByLocalidadLaboral", query = "SELECT t FROM Trabajador t WHERE t.localidadLaboral = :localidadLaboral")})
public class Trabajador implements Serializable {

    @Column(name = "sindicalizado")
    private Boolean sindicalizado;
    @Size(max = 100)
    @Column(name = "tipo_jornada")
    private String tipoJornada;
    @Size(max = 100)
    @Column(name = "periodicidad")
    private String periodicidad;
    @Size(max = 100)
    @Column(name = "numero_empleado")
    private String numeroEmpleado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    private Integer idTrabajador;
    @Size(max = 1)
    @Column(name = "url_foto")
    private String urlFoto;
    @Size(max = 1)
    @Column(name = "numero_licencia")
    private String numeroLicencia;
    @Size(max = 1)
    @Column(name = "vigencia_licencia")
    private String vigenciaLicencia;
    @Size(max = 1)
    @Column(name = "nss_trabajador")
    private String nssTrabajador;
    @Size(max = 1)
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;
    @Column(name = "sueldo")
    private Integer sueldo;
    @Column(name = "sueldo_integrado")
    private Integer sueldoIntegrado;
    @Size(max = 1)
    @Column(name = "puesto")
    private String puesto;
    @Size(max = 1)
    @Column(name = "riesgo_trabajo")
    private String riesgoTrabajo;
    @Size(max = 1)
    @Column(name = "tipo_contrato")
    private String tipoContrato;
    @Size(max = 1)
    @Column(name = "localidad_laboral")
    private String localidadLaboral;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Direccion idDireccion;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersona;
    @OneToMany(mappedBy = "idTrabajador", fetch = FetchType.LAZY)
    private List<Servicio> servicioList;

    public Trabajador() {
    }

    public Trabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgcv.dao.Trabajador[ idTrabajador=" + idTrabajador + " ]";
    }

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
    
}

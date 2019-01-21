/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio")
    , @NamedQuery(name = "Servicio.findByFolio", query = "SELECT s FROM Servicio s WHERE s.folio = :folio")
    , @NamedQuery(name = "Servicio.findByFechaSolicitud", query = "SELECT s FROM Servicio s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Servicio.findByFechaRealizacion", query = "SELECT s FROM Servicio s WHERE s.fechaRealizacion = :fechaRealizacion")
    , @NamedQuery(name = "Servicio.findByTipoCamion", query = "SELECT s FROM Servicio s WHERE s.tipoCamion = :tipoCamion")
    , @NamedQuery(name = "Servicio.findByPlacasCamion", query = "SELECT s FROM Servicio s WHERE s.placasCamion = :placasCamion")
    , @NamedQuery(name = "Servicio.findByTipoCarga", query = "SELECT s FROM Servicio s WHERE s.tipoCarga = :tipoCarga")
    , @NamedQuery(name = "Servicio.findByCiudadOrigen", query = "SELECT s FROM Servicio s WHERE s.ciudadOrigen = :ciudadOrigen")
    , @NamedQuery(name = "Servicio.findByCiudadDestino", query = "SELECT s FROM Servicio s WHERE s.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Servicio.findBySubTotal", query = "SELECT s FROM Servicio s WHERE s.subTotal = :subTotal")
    , @NamedQuery(name = "Servicio.findByIva", query = "SELECT s FROM Servicio s WHERE s.iva = :iva")
    , @NamedQuery(name = "Servicio.findByIsr", query = "SELECT s FROM Servicio s WHERE s.isr = :isr")
    , @NamedQuery(name = "Servicio.findByTotalCobrado", query = "SELECT s FROM Servicio s WHERE s.totalCobrado = :totalCobrado")
    , @NamedQuery(name = "Servicio.findByUtilidadNeta", query = "SELECT s FROM Servicio s WHERE s.utilidadNeta = :utilidadNeta")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Size(max = 1)
    @Column(name = "folio")
    private String folio;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizacion;
    @Size(max = 1)
    @Column(name = "tipo_camion")
    private String tipoCamion;
    @Size(max = 1)
    @Column(name = "placas_camion")
    private String placasCamion;
    @Size(max = 1)
    @Column(name = "tipo_carga")
    private String tipoCarga;
    @Size(max = 1)
    @Column(name = "ciudad_origen")
    private String ciudadOrigen;
    @Size(max = 1)
    @Column(name = "ciudad_destino")
    private String ciudadDestino;
    @Column(name = "sub_total")
    private Integer subTotal;
    @Column(name = "iva")
    private Integer iva;
    @Column(name = "isr")
    private Integer isr;
    @Column(name = "total_cobrado")
    private Integer totalCobrado;
    @Column(name = "utilidad_neta")
    private Integer utilidadNeta;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trabajador idTrabajador;
    @OneToMany(mappedBy = "idServicio", fetch = FetchType.LAZY)
    private List<CostoServicio> costoServicioList;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

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

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
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

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @XmlTransient
    public List<CostoServicio> getCostoServicioList() {
        return costoServicioList;
    }

    public void setCostoServicioList(List<CostoServicio> costoServicioList) {
        this.costoServicioList = costoServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgcv.dao.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}

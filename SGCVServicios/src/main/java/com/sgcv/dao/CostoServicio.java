/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "costo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CostoServicio.findAll", query = "SELECT c FROM CostoServicio c")
    , @NamedQuery(name = "CostoServicio.findByIdCosto", query = "SELECT c FROM CostoServicio c WHERE c.idCosto = :idCosto")
    , @NamedQuery(name = "CostoServicio.findByKilometrajeInicial", query = "SELECT c FROM CostoServicio c WHERE c.kilometrajeInicial = :kilometrajeInicial")
    , @NamedQuery(name = "CostoServicio.findByKilometrajeFinal", query = "SELECT c FROM CostoServicio c WHERE c.kilometrajeFinal = :kilometrajeFinal")
    , @NamedQuery(name = "CostoServicio.findByLitrosGastados", query = "SELECT c FROM CostoServicio c WHERE c.litrosGastados = :litrosGastados")
    , @NamedQuery(name = "CostoServicio.findByCalculoRendimiento", query = "SELECT c FROM CostoServicio c WHERE c.calculoRendimiento = :calculoRendimiento")
    , @NamedQuery(name = "CostoServicio.findByDieselCargado", query = "SELECT c FROM CostoServicio c WHERE c.dieselCargado = :dieselCargado")
    , @NamedQuery(name = "CostoServicio.findByCasetas", query = "SELECT c FROM CostoServicio c WHERE c.casetas = :casetas")
    , @NamedQuery(name = "CostoServicio.findByComision", query = "SELECT c FROM CostoServicio c WHERE c.comision = :comision")
    , @NamedQuery(name = "CostoServicio.findByViaticos", query = "SELECT c FROM CostoServicio c WHERE c.viaticos = :viaticos")
    , @NamedQuery(name = "CostoServicio.findByRefacciones", query = "SELECT c FROM CostoServicio c WHERE c.refacciones = :refacciones")
    , @NamedQuery(name = "CostoServicio.findByOtros", query = "SELECT c FROM CostoServicio c WHERE c.otros = :otros")})
public class CostoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_costo")
    private Integer idCosto;
    @Column(name = "kilometraje_inicial")
    private Integer kilometrajeInicial;
    @Column(name = "kilometraje_final")
    private Integer kilometrajeFinal;
    @Column(name = "litros_gastados")
    private Integer litrosGastados;
    @Size(max = 1)
    @Column(name = "calculo_rendimiento")
    private String calculoRendimiento;
    @Column(name = "diesel_cargado")
    private Integer dieselCargado;
    @Column(name = "casetas")
    private Integer casetas;
    @Column(name = "comision")
    private Integer comision;
    @Column(name = "viaticos")
    private Integer viaticos;
    @Column(name = "refacciones")
    private Integer refacciones;
    @Column(name = "otros")
    private Integer otros;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Servicio idServicio;

    public CostoServicio() {
    }

    public CostoServicio(Integer idCosto) {
        this.idCosto = idCosto;
    }

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

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCosto != null ? idCosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostoServicio)) {
            return false;
        }
        CostoServicio other = (CostoServicio) object;
        if ((this.idCosto == null && other.idCosto != null) || (this.idCosto != null && !this.idCosto.equals(other.idCosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgcv.dao.CostoServicio[ idCosto=" + idCosto + " ]";
    }
    
}

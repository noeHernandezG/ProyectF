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
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion")
    , @NamedQuery(name = "Direccion.findByCalle", query = "SELECT d FROM Direccion d WHERE d.calle = :calle")
    , @NamedQuery(name = "Direccion.findByNumero", query = "SELECT d FROM Direccion d WHERE d.numero = :numero")
    , @NamedQuery(name = "Direccion.findByCp", query = "SELECT d FROM Direccion d WHERE d.cp = :cp")
    , @NamedQuery(name = "Direccion.findByColonia", query = "SELECT d FROM Direccion d WHERE d.colonia = :colonia")
    , @NamedQuery(name = "Direccion.findByMunicipio", query = "SELECT d FROM Direccion d WHERE d.municipio = :municipio")
    , @NamedQuery(name = "Direccion.findByEntidadFederativa", query = "SELECT d FROM Direccion d WHERE d.entidadFederativa = :entidadFederativa")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer idDireccion;
    @Size(max = 1)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 1)
    @Column(name = "cp")
    private String cp;
    @Size(max = 1)
    @Column(name = "colonia")
    private String colonia;
    @Size(max = 1)
    @Column(name = "municipio")
    private String municipio;
    @Size(max = 1)
    @Column(name = "entidad_federativa")
    private String entidadFederativa;
    @OneToMany(mappedBy = "idDireccion", fetch = FetchType.LAZY)
    private List<Trabajador> trabajadorList;
    @OneToMany(mappedBy = "idDireccion", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public Direccion() {
    }

    public Direccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    @XmlTransient
    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgcv.dao.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}

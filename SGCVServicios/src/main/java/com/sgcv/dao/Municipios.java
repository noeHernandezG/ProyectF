/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")
    , @NamedQuery(name = "Municipios.findById", query = "SELECT m FROM Municipios m WHERE m.id = :id")
    , @NamedQuery(name = "Municipios.findByMunicipio", query = "SELECT m FROM Municipios m WHERE m.municipio = :municipio")
    , @NamedQuery(name = "Municipios.findByIdEstado", query = 
            "SELECT m.id, m.municipio FROM Municipios m "
          + "INNER JOIN EstadosMunicipios em on m.id=em.municipiosId "
          + "INNER JOIN Estados e on em.estadosId=e.id")})
public class Municipios implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipiosId", fetch = FetchType.LAZY)
    private List<EstadosMunicipios> estadosMunicipiosList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "municipio")
    private String municipio;

    public Municipios() {
    }

    public Municipios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sgcv.dao.Municipios[ id=" + id + " ]";
    }

    @XmlTransient
    public List<EstadosMunicipios> getEstadosMunicipiosList() {
        return estadosMunicipiosList;
    }

    public void setEstadosMunicipiosList(List<EstadosMunicipios> estadosMunicipiosList) {
        this.estadosMunicipiosList = estadosMunicipiosList;
    }
    
}

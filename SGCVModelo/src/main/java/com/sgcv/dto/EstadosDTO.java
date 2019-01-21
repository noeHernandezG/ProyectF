/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dto;

import java.util.List;

/**
 *
 * @author Ernesto
 */
public class EstadosDTO implements Comparable<MunicipiosDTO>{
    
    private Integer id;
    private String estado;
    private List<MunicipiosDTO> municipios;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<MunicipiosDTO> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipiosDTO> municipios) {
        this.municipios = municipios;
    }

    @Override
    public int compareTo(MunicipiosDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

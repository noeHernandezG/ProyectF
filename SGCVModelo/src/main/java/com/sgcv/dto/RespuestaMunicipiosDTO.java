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
public class RespuestaMunicipiosDTO {
    
    private ProcesoDTO proceso;
    private List<MunicipiosDTO> municipios;

    public ProcesoDTO getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoDTO proceso) {
        this.proceso = proceso;
    }

    public List<MunicipiosDTO> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipiosDTO> municipios) {
        this.municipios = municipios;
    }
    
    
    
}

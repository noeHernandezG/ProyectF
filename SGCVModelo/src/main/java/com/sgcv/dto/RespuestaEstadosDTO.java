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
public class RespuestaEstadosDTO {
    
    private ProcesoDTO proceso;
    private List<EstadosDTO> estados;

    public ProcesoDTO getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoDTO proceso) {
        this.proceso = proceso;
    }

    public List<EstadosDTO> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadosDTO> estados) {
        this.estados = estados;
    }

    
    
    
}

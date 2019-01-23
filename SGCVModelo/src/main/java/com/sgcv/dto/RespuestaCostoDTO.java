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
public class RespuestaCostoDTO {
    ProcesoDTO proceso;
    CostoDTO costo;

    public ProcesoDTO getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoDTO proceso) {
        this.proceso = proceso;
    }

    public CostoDTO getCosto() {
        return costo;
    }

    public void setCosto(CostoDTO costo) {
        this.costo = costo;
    }
    
    
}

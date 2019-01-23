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
public class RespuestaServiciosDTO {
 
    ProcesoDTO proceso;

    public ProcesoDTO getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoDTO proceso) {
        this.proceso = proceso;
    }

    public List<ServiciosDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServiciosDTO> servicios) {
        this.servicios = servicios;
    }
    List<ServiciosDTO> servicios;
    
    
    
}

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
public class RespuestaEmpleadoDTO {
    
    private ProcesoDTO proceso;
    private List<EmpleadoDTO> empleado;

    public ProcesoDTO getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoDTO proceso) {
        this.proceso = proceso;
    }

    public List<EmpleadoDTO> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<EmpleadoDTO> empleado) {
        this.empleado = empleado;
    }
    
}

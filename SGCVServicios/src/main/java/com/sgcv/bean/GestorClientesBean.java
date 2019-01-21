/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dto.RespuestaClientesDTO;

/**
 *
 * @author Ernesto
 */
public class GestorClientesBean {
    
    public RespuestaClientesDTO guardarCliente(RespuestaClientesDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO buscarCliente(RespuestaClientesDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO buscarClientes(){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO modificarCliente(RespuestaClientesDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO eliminarCliente(RespuestaClientesDTO cliente){
        return new RespuestaClientesDTO();
    }
}

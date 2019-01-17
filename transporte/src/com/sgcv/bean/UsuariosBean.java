/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.UsuarioDTO;

/**
 *
 * @author Ernesto
 */
public class UsuariosBean {
    
//    public ProcesoDTO registrarUsuario(UsuarioDTO usuario){
//        ProcesoDTO proceso=new ProcesoDTO();
//        proceso.setResultado(true);
//        
//    }
    
    public String validarDatosRegistro(UsuarioDTO usuario){
        if(usuario.getCorreo().equals(null)){
            return "Ingrese un correo electronico valido";
        }
        if
    }
}

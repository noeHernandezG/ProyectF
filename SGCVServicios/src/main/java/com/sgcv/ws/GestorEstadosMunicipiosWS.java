/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.ws;

import com.sgcv.bean.GestorEstadosMunicipiosBean;
import com.sgcv.dto.EstadosDTO;
import com.sgcv.dto.MunicipiosDTO;
import com.sgcv.dto.RespuestaEstadosDTO;
import com.sgcv.dto.RespuestaMunicipiosDTO;
import com.sgcv.dto.UsuarioDTO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ernesto
 */
@Path("gestorEstadosMunicipiosWS")
public class GestorEstadosMunicipiosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestorEstadosMunicipiosWS
     */
    public GestorEstadosMunicipiosWS() {
    }

//    @POST
//    @Path("insertarUsuario")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String insertarUsuario(UsuarioDTO usuario) {
//        String respuesta;
//        GestorUsuariosBean gestor=new GestorUsuariosBean();
//        respuesta = gestor.insertaUsuario(usuario);
//        return respuesta;
//    }
    
    @POST
    @Path("buscarEstados")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEstadosDTO buscarEstados() {
        GestorEstadosMunicipiosBean gestorEstados= new GestorEstadosMunicipiosBean();
        return gestorEstados.buscarEstados();
    }
    
    @POST
    @Path("buscarMunicipios")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEstadosDTO buscarMunicipios(EstadosDTO estado) {
        GestorEstadosMunicipiosBean gestorEstados= new GestorEstadosMunicipiosBean();
        System.out.println(""+estado.getId().toString());
        return gestorEstados.buscarMunicipios(estado.getId().toString());
    }
}

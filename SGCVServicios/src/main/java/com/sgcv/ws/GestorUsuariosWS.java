/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.ws;

import com.sgcv.bean.GestorUsuariosBean;
import com.sgcv.dto.UsuarioDTO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ernesto
 */
@Path("gestorUsuariosWS")
public class GestorUsuariosWS {

    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of GestorUsuariosWS
     */
    public GestorUsuariosWS() {
    }

    /**
     * Retrieves representation of an instance of com.sgcv.ws.GestorUsuariosWS
     * @param usuario
     * @return an instance of java.lang.String
     */
    @POST
    @Path("insertarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertarUsuario(UsuarioDTO usuario) {
        String respuesta;
        GestorUsuariosBean gestor=new GestorUsuariosBean();
        respuesta = gestor.insertaUsuario(usuario);
        return respuesta;
    }
    
    @POST
    @Path("modificaUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public String modificaUsuario(UsuarioDTO usuario) {
        //TODO return proper representation object
        String respuesta;
        GestorUsuariosBean gestor=new GestorUsuariosBean();
        respuesta = gestor.modificaUsuario(usuario);
        return respuesta;
    }
    
    @POST
    @Path("eliminarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public String eliminarUsuario(String idUsuario) {
        //TODO return proper representation object
        return "";
    }
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(UsuarioDTO usuario) {
        String respuesta;
        GestorUsuariosBean gestor=new GestorUsuariosBean();
        respuesta = gestor.login(usuario);
        return respuesta;
    }
}

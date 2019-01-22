/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.ws;

import com.sgcv.bean.GestorClientesBean;
import com.sgcv.dto.ClienteDTO;
import com.sgcv.dto.RespuestaClientesDTO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("gestorClientesWS")
public class GestorClientesWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestorClientesWS
     */
    public GestorClientesWS() {
    }

    @POST
    @Path("agregarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaClientesDTO agregarCliente(ClienteDTO cliente) {
        GestorClientesBean gestor = new GestorClientesBean();
        RespuestaClientesDTO respuesta = gestor.guardarCliente(cliente);
        return respuesta;
    }
    
    @POST
    @Path("modificarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaClientesDTO modificarCliente(ClienteDTO cliente) {
      GestorClientesBean gestor = new GestorClientesBean();
        RespuestaClientesDTO respuesta = gestor.modificarCliente(cliente);
        return respuesta;
    }
    
    @POST
    @Path("buscarClientes")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaClientesDTO buscarClientes() {
        GestorClientesBean gestor = new GestorClientesBean();
        RespuestaClientesDTO respuesta = gestor.buscarClientes();
        return respuesta;
    }
    
    @POST
    @Path("buscarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaClientesDTO buscarCliente(ClienteDTO cliente) {
       GestorClientesBean gestor = new GestorClientesBean();
        RespuestaClientesDTO respuesta = gestor.buscarCliente(cliente);
        return respuesta;
    }
    
//    @POST
//    @Path("buscarClientes")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String eliminarCliente() {
////        GestorEstadosMunicipiosBean gestorEstados= new GestorEstadosMunicipiosBean();
//        return "";
//    }
    /**
     * PUT method for updating or creating an instance of GestorClientesWS
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
}

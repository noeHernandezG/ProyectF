/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.ws;

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

    /**
     * Retrieves representation of an instance of com.sgcv.bean.GestorClientesWS
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    @POST
    @Path("buscarClientes")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarClientes() {
//        GestorEstadosMunicipiosBean gestorEstados= new GestorEstadosMunicipiosBean();
        return "";
    }
    /**
     * PUT method for updating or creating an instance of GestorClientesWS
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
}

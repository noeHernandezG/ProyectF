/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.ws;

import com.sgcv.bean.GestorServiciosBean;
import com.sgcv.dto.CostoDTO;
import com.sgcv.dto.RespuestaCostoDTO;
import com.sgcv.dto.RespuestaServiciosDTO;
import com.sgcv.dto.ServiciosDTO;
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
@Path("gestorServiciosWS")
public class GestorServiciosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestorServiciosWS
     */
    public GestorServiciosWS() {
    }

    @POST
    @Path("guardarServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaServiciosDTO guardarServicio(ServiciosDTO servicio) {
        GestorServiciosBean gestor = new GestorServiciosBean();
        RespuestaServiciosDTO respuesta = gestor.guardarServicio(servicio);
        return respuesta;
    }
    
    @POST
    @Path("modificarServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaServiciosDTO modificarServicio(ServiciosDTO servicio) {
        GestorServiciosBean gestor = new GestorServiciosBean();
        RespuestaServiciosDTO respuesta = gestor.modificarServicio(servicio);
        return respuesta;
    }
    
    @POST
    @Path("buscarServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaServiciosDTO buscarServicio(ServiciosDTO servicio) {
        GestorServiciosBean gestor = new GestorServiciosBean();
        RespuestaServiciosDTO respuesta = gestor.consultarServicio(servicio);
        return respuesta;
    }
    
    @POST
    @Path("buscarServicios")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaServiciosDTO buscarServicios() {
        GestorServiciosBean gestor = new GestorServiciosBean();
        RespuestaServiciosDTO respuesta = gestor.consultarServicios();
        return respuesta;
    }
    
    @POST
    @Path("borrarServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaServiciosDTO borrarServicio(ServiciosDTO servicio) {
        GestorServiciosBean gestor = new GestorServiciosBean();
        RespuestaServiciosDTO respuesta = gestor.eliminarServicio(servicio);
        return respuesta;
    }
    
    @POST
    @Path("guardarCosto")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaCostoDTO guardarCosto(CostoDTO costo) {
        GestorServiciosBean gestor = new GestorServiciosBean();
        RespuestaCostoDTO respuesta = gestor.guardaCosto(costo);
        return respuesta;
    }
    
//    @POST
//    @Path("buscarCosto")
//    @Produces(MediaType.APPLICATION_JSON)
//    public RespuestaCostoDTO buscarCosto(CostoDTO costo) {
//        GestorServiciosBean gestor = new GestorServiciosBean();
//        RespuestaCostoDTO respuesta = gestor.buscarCosto(costo);
//        return respuesta;
//    }
}

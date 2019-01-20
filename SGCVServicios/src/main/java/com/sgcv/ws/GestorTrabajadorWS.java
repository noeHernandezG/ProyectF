/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.ws;

import com.sgcv.bean.GestorTrabajadorBean;
import com.sgcv.dto.EmpleadoDTO;
import com.sgcv.dto.RespuestaEmpleadoDTO;
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
@Path("gestorTrabajadorWS")
public class GestorTrabajadorWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestorTrabajadorWS
     */
    public GestorTrabajadorWS() {
    }

    /**
     * Retrieves representation of an instance of com.sgcv.ws.GestorTrabajadorWS
     * @return an instance of java.lang.String
     */
    @POST
    @Path("guardarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmpleadoDTO guardarEmpleado(EmpleadoDTO empleado) {
        //TODO return proper representation object
        GestorTrabajadorBean gestor= new GestorTrabajadorBean();
        return gestor.guardarEmpleado(empleado);
    }

    @POST
    @Path("buscarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmpleadoDTO buscarEmpleado(EmpleadoDTO empleado) {
        GestorTrabajadorBean gestor= new GestorTrabajadorBean();
        return gestor.buscarEmpleado(empleado);
    }
    
    @POST
    @Path("buscarEmpleadoById")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmpleadoDTO buscarEmpleadoById(EmpleadoDTO empleado) {
        GestorTrabajadorBean gestor= new GestorTrabajadorBean();
        return gestor.buscarEmpleadoById(empleado);
    }
    
    @POST
    @Path("actualizarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado) {
        GestorTrabajadorBean gestor= new GestorTrabajadorBean();
        return gestor.actualizarEmpleado(empleado);
    }
    
    @POST
    @Path("eliminarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaEmpleadoDTO eliminarEmpleado(EmpleadoDTO empleado) {
        GestorTrabajadorBean gestor= new GestorTrabajadorBean();
        return gestor.eliminarEmpleado(empleado);
    }
    
}

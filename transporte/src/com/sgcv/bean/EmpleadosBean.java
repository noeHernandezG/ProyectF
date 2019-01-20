/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.google.gson.Gson;
import com.sgcv.dto.DireccionDTO;
import com.sgcv.dto.EmpleadoDTO;
import com.sgcv.dto.EstadosDTO;
import com.sgcv.dto.PersonaDTO;
import com.sgcv.dto.RespuestaEmpleadoDTO;
import com.sgcv.dto.RespuestaEstadosDTO;
import com.sgcv.utils.ClienteREST;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class EmpleadosBean {
    
    public String url="http://192.168.56.1:7001/SGCVServicios/resources/gestorTrabajadorWS/guardarEmpleado";
    private String urlEstados="http://192.168.56.1:7001/SGCVServicios/resources/gestorEstadosMunicipiosWS/buscarEstados";
    private String urlMunicipios="http://192.168.56.1:7001/SGCVServicios/resources/gestorEstadosMunicipiosWS/buscarMunicipios";
    private String urlEmpleados="http://192.168.56.1:7001/SGCVServicios/resources/gestorTrabajadorWS/buscarEmpleado";
    public String metodo="POST";
    
    public String registrarEmpleado(EmpleadoDTO empleado){
        Gson gson=new Gson();
        String request=gson.toJson(empleado);
        System.out.println(request);
        ClienteREST cliente=new ClienteREST();
        String response=cliente.getResponse(url, metodo, request);
        System.out.println(response);
        return response;
    }
    
    public RespuestaEstadosDTO getEstados(){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String respuesta=cliente.getResponseDTO(urlEstados, metodo, "");
        System.out.println(respuesta);
        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return estados;
    }
    
    public RespuestaEstadosDTO getMunicipios(EstadosDTO estadosDTO){
        Gson gson=new Gson();
        String request=gson.toJson(estadosDTO);
        ClienteREST cliente=new ClienteREST();
        String respuesta=cliente.getResponseDTO(urlMunicipios, metodo, request);
        System.out.println(respuesta);
        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return estados;
    }
    
    public RespuestaEmpleadoDTO getEmpleados(){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String request=gson.toJson(new EmpleadoDTO());
        System.out.println(""+request);
        String response=cliente.getResponseDTO(urlEmpleados, metodo, request);
        RespuestaEmpleadoDTO empleados=gson.fromJson(response, RespuestaEmpleadoDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return empleados;
    }
    public static void main(String[] args) {
        EmpleadoDTO empleado= new EmpleadoDTO();
        DireccionDTO direccion= new DireccionDTO();
        PersonaDTO persona= new PersonaDTO();
        direccion.setCalle("afsdd");
        direccion.setColonia("afsdd");
        direccion.setCp("afsdd");
        direccion.setEntidadFederativa("afsdd");
//        direccion.setIdDireccion(1);
        direccion.setMunicipio("afsdd");
        direccion.setNumero("aasdas");
        empleado.setIdDireccion(direccion);
        empleado.setIdPersona(persona);
        empleado.setFechaIngreso("12-11-2018");
//        empleado.setFechaIngreso("12-11-2010");
        Gson gson=new Gson();
        String json=gson.toJson(empleado);
        System.out.println(json);
//        GestorTrabajadorBean gestor = new GestorTrabajadorBean();
//        gestor.guardarEmpleado(empleado);
    }
}

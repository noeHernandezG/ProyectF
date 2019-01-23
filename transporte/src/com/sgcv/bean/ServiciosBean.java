/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.google.gson.Gson;
import com.sgcv.dto.RespuestaServiciosDTO;
import com.sgcv.dto.ServiciosDTO;
import com.sgcv.utils.ClienteREST;

/**
 *
 * @author Ernesto
 */
public class ServiciosBean {
    String metodo="POST";
    String guardaCliente="http://192.168.56.1:7001/SGCVServicios/resources/gestorServiciosWS/guardarServicio";
    
    public RespuestaServiciosDTO guardarServicio(ServiciosDTO servicio){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String request=gson.toJson(servicio);
        System.out.println(""+request);
        String response=cliente.getResponseDTO(guardaCliente, metodo, request);
        RespuestaServiciosDTO respuesta=gson.fromJson(response, RespuestaServiciosDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return respuesta;
    }
    
    public RespuestaServiciosDTO buscarServicio(ServiciosDTO servicio){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String request=gson.toJson(servicio);
        System.out.println(""+request);
        String response=cliente.getResponseDTO(guardaCliente, metodo, request);
        RespuestaServiciosDTO respuesta=gson.fromJson(response, RespuestaServiciosDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return respuesta;
    }
    
    public RespuestaServiciosDTO buscarServicios(){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
//        String request=gson.toJson( );
//        System.out.println(""+request);
        String response=cliente.getResponseDTO(guardaCliente, metodo, "");
        RespuestaServiciosDTO respuesta=gson.fromJson(response, RespuestaServiciosDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return respuesta;
    }
}

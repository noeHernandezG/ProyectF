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
import java.util.Date;

/**
 *
 * @author Ernesto
 */
public class ServiciosBean {
    String metodo="POST";
    String guardaCliente="http://192.168.56.1:7001/SGCVServicios/resources/gestorServiciosWS/guardarServicio";
    String buscarServicios="http://192.168.56.1:7001/SGCVServicios/resources/gestorServiciosWS/buscarServicios";
    String buscarServicio="http://192.168.56.1:7001/SGCVServicios/resources/gestorServiciosWS/buscarServicio";
    
    public RespuestaServiciosDTO guardarServicio(ServiciosDTO servicio){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String request=gson.toJson(servicio);
        System.out.println(""+request);
//        System.out.println(servicio.getFechaSolicitud());
//        System.out.println(servicio.getFechaRealizacion());
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
        String response=cliente.getResponseDTO(buscarServicio, metodo, request);
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
        String response=cliente.getResponseDTO(buscarServicios, metodo, "");
        RespuestaServiciosDTO respuesta=gson.fromJson(response, RespuestaServiciosDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return respuesta;
    }
    public static void main(String[] args) {
        System.out.println(new Date().toString());
    }
}

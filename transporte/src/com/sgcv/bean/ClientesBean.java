/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.google.gson.Gson;
import com.sgcv.dto.ClienteDTO;
import com.sgcv.dto.DireccionDTO;
import com.sgcv.dto.EmpleadoDTO;
import com.sgcv.dto.PersonaDTO;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaClientesDTO;
import com.sgcv.dto.RespuestaEmpleadoDTO;
import com.sgcv.utils.ClienteREST;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class ClientesBean {
    
    String urlGuarda="http://192.168.56.1:7001/SGCVServicios/resources/gestorClientesWS/agregarCliente";
    String urlBusca="http://192.168.56.1:7001/SGCVServicios/resources/gestorClientesWS/buscarClientes";
    String urlBuscaCliente="http://192.168.56.1:7001/SGCVServicios/resources/gestorClientesWS/buscarCliente";
    String metodo="POST";
    
    public RespuestaClientesDTO guardarCliente(ClienteDTO clienteDTO){
        Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String request=gson.toJson(clienteDTO);
        System.out.println(""+request);
        String response=cliente.getResponseDTO(urlGuarda, metodo, request);
        RespuestaClientesDTO clientes=gson.fromJson(response, RespuestaClientesDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return clientes;
    }
    
    public RespuestaClientesDTO buscarCliente(ClienteDTO cliente){
        Gson gson=new Gson();
        ClienteREST clienteR=new ClienteREST();
        String request=gson.toJson(cliente);
        System.out.println(""+request);
        String response=clienteR.getResponseDTO(urlBuscaCliente, metodo, request);
        System.out.println(request);
        RespuestaClientesDTO clientes = gson.fromJson(response, RespuestaClientesDTO.class);
        return clientes;
    }
    
    public RespuestaClientesDTO buscarClientes(){
         Gson gson=new Gson();
        ClienteREST cliente=new ClienteREST();
        String request=gson.toJson(new ClienteDTO());
        System.out.println(""+request);
        String response=cliente.getResponseDTO(urlBusca, metodo, request);
        RespuestaClientesDTO clientes=gson.fromJson(response, RespuestaClientesDTO.class);
//        System.out.println(respuesta);
//        RespuestaEstadosDTO estados = gson.fromJson(respuesta, RespuestaEstadosDTO.class);
        return clientes;
    }
    
    public RespuestaClientesDTO modificarCliente(ClienteDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO eliminarCliente(ClienteDTO cliente){
        return new RespuestaClientesDTO();
    }
}

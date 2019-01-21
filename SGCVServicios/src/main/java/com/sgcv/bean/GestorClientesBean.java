/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Cliente;
import com.sgcv.dao.Direccion;
import com.sgcv.dao.Persona;
import com.sgcv.dto.ClienteDTO;
import com.sgcv.dto.DireccionDTO;
import com.sgcv.dto.PersonaDTO;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaClientesDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class GestorClientesBean {
    
    public RespuestaClientesDTO guardarCliente(ClienteDTO clienteDTO){
        RespuestaClientesDTO respuesta= new RespuestaClientesDTO();
        List<ClienteDTO> clientes= new ArrayList();
        ProcesoDTO proceso= new ProcesoDTO();
        try{
            Cliente cliente = new Cliente();
            Direccion direccion = new Direccion();
            Persona persona = new Persona();
            cliente.setIdDireccion(direccion);
            cliente.setIdPersona(persona);
            Dao<Cliente> dao= new Dao<Cliente>(Cliente.class);
            proceso.setResultado(dao.inserta(cliente));
//            System.out.println("Total "+result);
            if(proceso.isResultado()){
                proceso.setMensaje("El cliente se guardo con exito");
            }else{
                proceso.setMensaje("No se pudo guardar al clienete");
            }
        }catch(Exception e){
            e.printStackTrace();
            proceso.setResultado(false);
            proceso.setMensaje("Error al registrar cliente");
        }
        
        respuesta.setProceso(proceso);
        respuesta.setClientes(clientes);
        return respuesta;
    }
    
    public RespuestaClientesDTO buscarCliente(ClienteDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO buscarClientes(){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO modificarCliente(ClienteDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public RespuestaClientesDTO eliminarCliente(ClienteDTO cliente){
        return new RespuestaClientesDTO();
    }
    
    public static void main(String[] args) {
//        GSON gson = new GSON();
        ClienteDTO cliente = new ClienteDTO();
        DireccionDTO direccion = new DireccionDTO();
        direccion.setCalle("calle 1");
        direccion.setColonia("colonia 1");
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("persona 1");
        persona.setaMaterno("materno 1");
//        cliente.setPersona(persona);
//        cliente.s
        cliente.setDireccion(direccion);
        cliente.setPersona(persona);
        
        GestorClientesBean gestor = new GestorClientesBean();
        RespuestaClientesDTO respuesta= gestor.guardarCliente(cliente);
        System.out.println(respuesta.getProceso().getMensaje());
        System.out.println(respuesta.getProceso().isResultado());
    }
}

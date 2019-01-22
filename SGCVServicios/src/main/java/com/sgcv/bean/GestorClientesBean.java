/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Cliente;
import com.sgcv.dao.Direccion;
import com.sgcv.dao.Parametros;
import com.sgcv.dao.Persona;
import com.sgcv.dto.ClienteDTO;
import com.sgcv.dto.DireccionDTO;
import com.sgcv.dto.PersonaDTO;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaClientesDTO;
import com.sgcv.utils.CONSTANTE;
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
            direccion.setCalle(clienteDTO.getDireccion().getCalle());
            direccion.setColonia(clienteDTO.getDireccion().getColonia());
            direccion.setCp(clienteDTO.getDireccion().getCp());
            direccion.setEntidadFederativa(clienteDTO.getDireccion().getEntidadFederativa());
            direccion.setMunicipio(clienteDTO.getDireccion().getMunicipio());
            direccion.setNumero(clienteDTO.getDireccion().getNumero());
            
            Persona persona = new Persona();
            persona.setNombre(clienteDTO.getPersona().getNombre());
            persona.setAMaterno(clienteDTO.getPersona().getaMaterno());
            persona.setAPaterno(clienteDTO.getPersona().getaPaterno());
            persona.setTipoPersona(clienteDTO.getPersona().getTipoPersona());
            persona.setCorreo(clienteDTO.getPersona().getCorreo());
            persona.setTelefono1(clienteDTO.getPersona().getTelefono1());
            persona.setTelefono2(clienteDTO.getPersona().getTelefono2());
            persona.setRfc(clienteDTO.getPersona().getRfc());
            
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
    
    public RespuestaClientesDTO buscarCliente(ClienteDTO clienteDTO){
        System.out.println("el id es "+clienteDTO.getIdCliente());
        RespuestaClientesDTO respuesta= new RespuestaClientesDTO();
        ProcesoDTO proceso= new ProcesoDTO();
        List<ClienteDTO> clientesDto = new ArrayList();
        try{
            
            Dao<Cliente> dao= new Dao<Cliente>(Cliente.class);
            List<Parametros> parametros= new ArrayList();
            parametros.add(new Parametros(CONSTANTE.NUMERO,clienteDTO.getIdCliente().toString(),"idCliente"));
            List<Cliente> clientes = dao.consultaQueryByParametros("Cliente.findByIdCliente", parametros);
            for(Cliente cliente:clientes){
                PersonaDTO persona = new PersonaDTO();
                persona.setCorreo(cliente.getIdPersona().getCorreo());
                persona.setCurp(cliente.getIdPersona().getCurp());
                persona.setFechaNacimiento(cliente.getIdPersona().getFechaNacimiento());
                persona.setIdPersona(cliente.getIdPersona().getIdPersona());
                persona.setNombre(cliente.getIdPersona().getNombre());
                persona.setRfc(cliente.getIdPersona().getRfc());
                persona.setSexo(cliente.getIdPersona().getSexo());
                persona.setTelefono1(cliente.getIdPersona().getTelefono1());
                persona.setTelefono2(cliente.getIdPersona().getTelefono2());
                persona.setTipoPersona(cliente.getIdPersona().getTipoPersona());
                persona.setaMaterno(cliente.getIdPersona().getAMaterno());
                persona.setaPaterno(cliente.getIdPersona().getAPaterno());
                
                DireccionDTO direccion = new DireccionDTO();
                direccion.setCalle(cliente.getIdDireccion().getCalle());
                direccion.setColonia(cliente.getIdDireccion().getColonia());
                direccion.setCp(cliente.getIdDireccion().getCp());
                direccion.setEntidadFederativa(cliente.getIdDireccion().getEntidadFederativa());
                direccion.setIdDireccion(cliente.getIdDireccion().getIdDireccion());
                direccion.setMunicipio(cliente.getIdDireccion().getMunicipio());
                direccion.setNumero(cliente.getIdDireccion().getNumero());
                
                ClienteDTO clienteDto = new ClienteDTO();
                clienteDto.setDireccion(direccion);
                clienteDto.setPersona(persona);
                clienteDto.setIdCliente(cliente.getIdCliente());
                
                clientesDto.add(clienteDto);
                
            }
//            System.out.println("Total "+result);
            proceso.setResultado(true);
            if(proceso.isResultado()){
                proceso.setMensaje("clientes encontrados con exito");
            }else{
                proceso.setMensaje("no se pudo buscar clientes");
            }
        }catch(Exception e){
            e.printStackTrace();
            proceso.setResultado(false);
            proceso.setMensaje("Error al buscar cliente");
        }
        
        respuesta.setProceso(proceso);
        respuesta.setClientes(clientesDto);
        return respuesta;
    }
    
    public RespuestaClientesDTO buscarClientes(){
        RespuestaClientesDTO respuesta= new RespuestaClientesDTO();
        ProcesoDTO proceso= new ProcesoDTO();
        List<ClienteDTO> clienteDTO = new ArrayList();
        try{
            
            Dao<Cliente> dao= new Dao<Cliente>(Cliente.class);
            List<Cliente> clientes = dao.consultaNmed("Cliente.findAll");
            for(Cliente cliente:clientes){
                PersonaDTO persona = new PersonaDTO();
                persona.setCorreo(cliente.getIdPersona().getCorreo());
                persona.setCurp(cliente.getIdPersona().getCurp());
                persona.setFechaNacimiento(cliente.getIdPersona().getFechaNacimiento());
                persona.setIdPersona(cliente.getIdPersona().getIdPersona());
                persona.setNombre(cliente.getIdPersona().getNombre());
                persona.setRfc(cliente.getIdPersona().getRfc());
                persona.setSexo(cliente.getIdPersona().getSexo());
                persona.setTelefono1(cliente.getIdPersona().getTelefono1());
                persona.setTelefono2(cliente.getIdPersona().getTelefono2());
                persona.setTipoPersona(cliente.getIdPersona().getTipoPersona());
                persona.setaMaterno(cliente.getIdPersona().getAMaterno());
                persona.setaPaterno(cliente.getIdPersona().getAPaterno());
                
                DireccionDTO direccion = new DireccionDTO();
                direccion.setCalle(cliente.getIdDireccion().getCalle());
                direccion.setColonia(cliente.getIdDireccion().getColonia());
                direccion.setCp(cliente.getIdDireccion().getCp());
                direccion.setEntidadFederativa(cliente.getIdDireccion().getEntidadFederativa());
                direccion.setIdDireccion(cliente.getIdDireccion().getIdDireccion());
                direccion.setMunicipio(cliente.getIdDireccion().getMunicipio());
                direccion.setNumero(cliente.getIdDireccion().getNumero());
                
                ClienteDTO clienteDto = new ClienteDTO();
                clienteDto.setDireccion(direccion);
                clienteDto.setPersona(persona);
                clienteDto.setIdCliente(cliente.getIdCliente());
                
                clienteDTO.add(clienteDto);
                
            }
//            System.out.println("Total "+result);
            proceso.setResultado(true);
            if(proceso.isResultado()){
                proceso.setMensaje("clientes encontrados con exito");
            }else{
                proceso.setMensaje("no se pudo buscar clientes");
            }
        }catch(Exception e){
            e.printStackTrace();
            proceso.setResultado(false);
            proceso.setMensaje("Error al buscar cliente");
        }
        
        respuesta.setProceso(proceso);
        respuesta.setClientes(clienteDTO);
        return respuesta;
    }
    
    public RespuestaClientesDTO modificarCliente(ClienteDTO clienteDTO){
        RespuestaClientesDTO respuesta= new RespuestaClientesDTO();
        List<ClienteDTO> clientes= new ArrayList();
        ProcesoDTO proceso= new ProcesoDTO();
        try{
            Cliente cliente = new Cliente();
            
            Direccion direccion = new Direccion();
            direccion.setCalle(clienteDTO.getDireccion().getCalle());
            direccion.setColonia(clienteDTO.getDireccion().getColonia());
            direccion.setCp(clienteDTO.getDireccion().getCp());
            direccion.setEntidadFederativa(clienteDTO.getDireccion().getEntidadFederativa());
            direccion.setMunicipio(clienteDTO.getDireccion().getMunicipio());
            direccion.setNumero(clienteDTO.getDireccion().getNumero());
            direccion.setIdDireccion(clienteDTO.getDireccion().getIdDireccion());
            
            Persona persona = new Persona();
            persona.setNombre(clienteDTO.getPersona().getNombre());
            persona.setAMaterno(clienteDTO.getPersona().getaMaterno());
            persona.setAPaterno(clienteDTO.getPersona().getaPaterno());
            persona.setTipoPersona(clienteDTO.getPersona().getTipoPersona());
            persona.setCorreo(clienteDTO.getPersona().getCorreo());
            persona.setTelefono1(clienteDTO.getPersona().getTelefono1());
            persona.setTelefono2(clienteDTO.getPersona().getTelefono2());
            persona.setRfc(clienteDTO.getPersona().getRfc());
            persona.setIdPersona(clienteDTO.getPersona().getIdPersona());
            
            cliente.setIdDireccion(direccion);
            cliente.setIdPersona(persona);
            cliente.setIdCliente(clienteDTO.getIdCliente());
            Dao<Cliente> dao= new Dao<Cliente>(Cliente.class);
            proceso.setResultado(dao.actualiza(cliente));
//            System.out.println("Total "+result);
            if(proceso.isResultado()){
                proceso.setMensaje("El cliente se modifico con exito");
            }else{
                proceso.setMensaje("No se pudo modificar al clienete");
            }
        }catch(Exception e){
            e.printStackTrace();
            proceso.setResultado(false);
            proceso.setMensaje("Error al modificar cliente");
        }
        
        respuesta.setProceso(proceso);
        respuesta.setClientes(clientes);
        return respuesta;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Cliente;
import com.sgcv.dao.Dao;
import com.sgcv.dao.Parametros;
import com.sgcv.dao.Persona;
import com.sgcv.dao.Servicio;
import com.sgcv.dto.ClienteDTO;
import com.sgcv.dto.PersonaDTO;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaServiciosDTO;
import com.sgcv.dto.ServiciosDTO;
import com.sgcv.utils.CONSTANTE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class GestorServiciosBean {
    
    public RespuestaServiciosDTO guardarServicio(ServiciosDTO servicioDTO){
        RespuestaServiciosDTO respuesta=new RespuestaServiciosDTO();
        ProcesoDTO proceso= new ProcesoDTO();
//        List<ServiciosDTO> servicios = new ArrayList();

        try{
            Cliente cliente= new Cliente();
            Persona persona= new Persona();
            persona.setNombre(servicioDTO.getIdCliente().getPersona().getNombre());
            persona.setRfc(servicioDTO.getIdCliente().getPersona().getRfc());
            persona.setTelefono1(servicioDTO.getIdCliente().getPersona().getTelefono1());
            cliente.setIdPersona(persona);
            
            Servicio servicio= new Servicio();
            servicio.setIdCliente(cliente);
            servicio.setCiudadDestino(servicioDTO.getCiudadDestino());
            servicio.setCiudadOrigen(servicioDTO.getCiudadOrigen());
    //        servicio.setCostoServicioList(costoServicioList);
            System.out.println("fecha realizacion "+servicioDTO.getFechaRealizacion());
            servicio.setFechaRealizacion(servicioDTO.getFechaRealizacion());
            servicio.setFechaSolicitud(servicioDTO.getFechaSolicitud());
            servicio.setFolio(servicioDTO.getFolio());
    //        servicio.setIdCliente(servicioDTO.getIdCliente());
            servicio.setIdServicio(servicioDTO.getIdServicio());
            servicio.setIsr(servicioDTO.getIsr());
            servicio.setIva(servicioDTO.getIva());
            servicio.setPlacasCamion(servicioDTO.getPlacasCamion());
            servicio.setSubTotal(servicioDTO.getSubTotal());
            servicio.setTipoCamion(servicioDTO.getTipoCamion());
            servicio.setTipoCarga(servicioDTO.getTipoCarga());
            servicio.setTotalCobrado(servicioDTO.getTotalCobrado());
            servicio.setUtilidadNeta(servicioDTO.getUtilidadNeta());
            Dao<Servicio> dao= new Dao<Servicio>(Servicio.class);
            proceso.setResultado(dao.inserta(servicio));
//            System.out.println("Total "+result);
            if(proceso.isResultado()){
                proceso.setMensaje("El servicio se guardo con exito");
            }else{
                proceso.setMensaje("No se pudo registrar el servicio");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            proceso.setMensaje("Error al buscar servicios");
            proceso.setResultado(false);
        }
        respuesta.setProceso(proceso);
        return respuesta;
    }
    
    public RespuestaServiciosDTO modificarServicio(ServiciosDTO servicioDTO){
        RespuestaServiciosDTO respuesta=new RespuestaServiciosDTO();
        ProcesoDTO proceso= new ProcesoDTO();
//        List<ServiciosDTO> servicios = new ArrayList();

        try{
            Servicio servicio= new Servicio();
            servicio.setCiudadDestino(servicioDTO.getCiudadDestino());
            servicio.setCiudadOrigen(servicioDTO.getCiudadOrigen());
    //        servicio.setCostoServicioList(costoServicioList);
            servicio.setFechaRealizacion(servicioDTO.getFechaRealizacion());
            servicio.setFechaSolicitud(servicioDTO.getFechaSolicitud());
            servicio.setFolio(servicioDTO.getFolio());
    //        servicio.setIdCliente(servicioDTO.getIdCliente());
            servicio.setIdServicio(servicioDTO.getIdServicio());
            servicio.setIsr(servicioDTO.getIsr());
            servicio.setIva(servicioDTO.getIva());
            servicio.setPlacasCamion(servicioDTO.getPlacasCamion());
            servicio.setSubTotal(servicioDTO.getSubTotal());
            servicio.setTipoCamion(servicioDTO.getTipoCamion());
            servicio.setTipoCarga(servicioDTO.getTipoCarga());
            servicio.setTotalCobrado(servicioDTO.getTotalCobrado());
            servicio.setUtilidadNeta(servicioDTO.getUtilidadNeta());
            Dao<Servicio> dao= new Dao<Servicio>(Servicio.class);
            proceso.setResultado(dao.inserta(servicio));
//            System.out.println("Total "+result);
            if(proceso.isResultado()){
                proceso.setMensaje("El servicio se guardo con exito");
            }else{
                proceso.setMensaje("No se pudo registrar el servicio");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            proceso.setMensaje("Error al buscar servicios");
            proceso.setResultado(false);
        }
        respuesta.setProceso(proceso);
        return respuesta;
    }
    
    public RespuestaServiciosDTO consultarServicio(ServiciosDTO servicioDTO){
        RespuestaServiciosDTO respuesta=new RespuestaServiciosDTO();
        ProcesoDTO proceso= new ProcesoDTO();
        List<ServiciosDTO> serviciosDTO = new ArrayList();
       
        try{
            List<Parametros> parametros = new ArrayList();
            parametros.add(new Parametros(CONSTANTE.NUMERO,servicioDTO.getIdServicio().toString(),"idServicio"));
            Dao<Servicio> dao= new Dao<Servicio>(Servicio.class);
            List<Servicio> servicios = dao.consultaQueryByParametros("Servicio.findByIdServicio",parametros);
            for(Servicio servicio: servicios){
                ServiciosDTO servicioDto= new ServiciosDTO();
                ClienteDTO cliente= new ClienteDTO();
                PersonaDTO persona = new PersonaDTO();
//                persona.setCorreo(servicio.getIdCliente().getIdPersona().getCorreo());
//                persona.setCurp(servicio.getIdCliente().getIdPersona().getCurp());
//                persona.setFechaNacimiento(servicio.getIdCliente().getIdPersona().getFechaNacimiento());
                persona.setIdPersona(servicio.getIdCliente().getIdPersona().getIdPersona());
                persona.setNombre(servicio.getIdCliente().getIdPersona().getNombre());
                persona.setRfc(servicio.getIdCliente().getIdPersona().getRfc());
//                persona.setSexo(servicio.getIdCliente().getIdPersona().getSexo());
                persona.setTelefono1(servicio.getIdCliente().getIdPersona().getTelefono1());
//                persona.setTelefono2(servicio.getIdCliente().getIdPersona().getTelefono2());
//                persona.setTipoPersona(servicio.getIdCliente().getIdPersona().getTipoPersona());
//                persona.setaMaterno(servicio.getIdCliente().getIdPersona().getAMaterno());
//                persona.setaPaterno(servicio.getIdCliente().getIdPersona().getAPaterno());
                
                cliente.setPersona(persona);
                
                servicioDto.setCiudadDestino(servicio.getCiudadDestino());
                servicioDto.setCiudadOrigen(servicio.getCiudadOrigen());
            //        servicio.setCostoServicioList(costoServicioList);
                servicioDto.setFechaRealizacion(servicio.getFechaRealizacion());
                servicioDto.setFechaSolicitud(servicio.getFechaSolicitud());
                servicioDto.setFolio(servicio.getFolio());
                servicioDto.setIdCliente(cliente);
                servicioDto.setIdServicio(servicio.getIdServicio());
                servicioDto.setIsr(servicio.getIsr());
                servicioDto.setIva(servicio.getIva());
                servicioDto.setPlacasCamion(servicio.getPlacasCamion());
                servicioDto.setSubTotal(servicio.getSubTotal());
                servicioDto.setTipoCamion(servicio.getTipoCamion());
                servicioDto.setTipoCarga(servicio.getTipoCarga());
                servicioDto.setTotalCobrado(servicio.getTotalCobrado());
                servicioDto.setUtilidadNeta(servicio.getUtilidadNeta());
                servicioDto.setIdServicio(servicio.getIdServicio());
                serviciosDTO.add(servicioDto);
            }
           proceso.setResultado(true);
           proceso.setMensaje("Se encontro el servicio");
        }catch(Exception e){
            e.printStackTrace();
            proceso.setMensaje("Error al buscar servicios");
            proceso.setResultado(false);
        }
        respuesta.setProceso(proceso);
        respuesta.setServicios(serviciosDTO);
        return respuesta;
    }
    
    public RespuestaServiciosDTO consultarServicios(){
       RespuestaServiciosDTO respuesta=new RespuestaServiciosDTO();
        ProcesoDTO proceso= new ProcesoDTO();
        List<ServiciosDTO> serviciosDTO = new ArrayList();
       
        try{
            Dao<Servicio> dao= new Dao<Servicio>(Servicio.class);
            List<Servicio> servicios = dao.consultaNmed("Servicio.findAll");
            for(Servicio servicio: servicios){
                ServiciosDTO servicioDto= new ServiciosDTO();
                ClienteDTO cliente= new ClienteDTO();
                PersonaDTO persona = new PersonaDTO();
//                persona.setCorreo(servicio.getIdCliente().getIdPersona().getCorreo());
//                persona.setCurp(servicio.getIdCliente().getIdPersona().getCurp());
//                persona.setFechaNacimiento(servicio.getIdCliente().getIdPersona().getFechaNacimiento());
                persona.setIdPersona(servicio.getIdCliente().getIdPersona().getIdPersona());
                persona.setNombre(servicio.getIdCliente().getIdPersona().getNombre());
                persona.setRfc(servicio.getIdCliente().getIdPersona().getRfc());
//                persona.setSexo(servicio.getIdCliente().getIdPersona().getSexo());
                persona.setTelefono1(servicio.getIdCliente().getIdPersona().getTelefono1());
//                persona.setTelefono2(servicio.getIdCliente().getIdPersona().getTelefono2());
//                persona.setTipoPersona(servicio.getIdCliente().getIdPersona().getTipoPersona());
//                persona.setaMaterno(servicio.getIdCliente().getIdPersona().getAMaterno());
//                persona.setaPaterno(servicio.getIdCliente().getIdPersona().getAPaterno());
                
                cliente.setPersona(persona);
                
                servicioDto.setCiudadDestino(servicio.getCiudadDestino());
                servicioDto.setCiudadOrigen(servicio.getCiudadOrigen());
            //        servicio.setCostoServicioList(costoServicioList);
                servicioDto.setFechaRealizacion(servicio.getFechaRealizacion());
                servicioDto.setFechaSolicitud(servicio.getFechaSolicitud());
                servicioDto.setFolio(servicio.getFolio());
                servicioDto.setIdCliente(cliente);
                servicioDto.setIdServicio(servicio.getIdServicio());
                servicioDto.setIsr(servicio.getIsr());
                servicioDto.setIva(servicio.getIva());
                servicioDto.setPlacasCamion(servicio.getPlacasCamion());
                servicioDto.setSubTotal(servicio.getSubTotal());
                servicioDto.setTipoCamion(servicio.getTipoCamion());
                servicioDto.setTipoCarga(servicio.getTipoCarga());
                servicioDto.setTotalCobrado(servicio.getTotalCobrado());
                servicioDto.setUtilidadNeta(servicio.getUtilidadNeta());
                servicioDto.setIdServicio(servicio.getIdServicio());
                serviciosDTO.add(servicioDto);
            }
//            
        }catch(Exception e){
            e.printStackTrace();
            proceso.setMensaje("Error al buscar servicios");
            proceso.setResultado(false);
        }
        respuesta.setProceso(proceso);
        respuesta.setServicios(serviciosDTO);
        return respuesta;
    }
    
    public RespuestaServiciosDTO eliminarServicio(ServiciosDTO servicio){
        
        
        return new RespuestaServiciosDTO();
    }
    
    
}

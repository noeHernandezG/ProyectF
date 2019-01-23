/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Servicio;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaServiciosDTO;
import com.sgcv.dto.ServiciosDTO;
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
    
    public RespuestaServiciosDTO modificarServicio(ServiciosDTO servicio){
        
        
        return new RespuestaServiciosDTO();
    }
    
    public RespuestaServiciosDTO consultarServicio(ServiciosDTO servicioDTO){
        RespuestaServiciosDTO respuesta=new RespuestaServiciosDTO();
        ProcesoDTO proceso= new ProcesoDTO();
        List<ServiciosDTO> serviciosDTO = new ArrayList();
       
        try{
            Dao<Servicio> dao= new Dao<Servicio>(Servicio.class);
            List<Servicio> servicios = dao.consulta("Servicio.findAll");
            for(Servicio servicio: servicios){
                ServiciosDTO servicioDto= new ServiciosDTO();
                servicioDto.setCiudadDestino(servicio.getCiudadDestino());
                servicioDto.setCiudadOrigen(servicio.getCiudadOrigen());
            //        servicio.setCostoServicioList(costoServicioList);
                servicioDto.setFechaRealizacion(servicio.getFechaRealizacion());
                servicioDto.setFechaSolicitud(servicio.getFechaSolicitud());
                servicioDto.setFolio(servicio.getFolio());
            //        servicio.setIdCliente(servicioDTO.getIdCliente());
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
    
    public RespuestaServiciosDTO consultarServicios(){
       RespuestaServiciosDTO respuesta=new RespuestaServiciosDTO();
        ProcesoDTO proceso= new ProcesoDTO();
        List<ServiciosDTO> serviciosDTO = new ArrayList();
       
        try{
            Dao<Servicio> dao= new Dao<Servicio>(Servicio.class);
            List<Servicio> servicios = dao.consulta("Servicio.findAll");
            for(Servicio servicio: servicios){
                ServiciosDTO servicioDto= new ServiciosDTO();
                servicioDto.setCiudadDestino(servicio.getCiudadDestino());
                servicioDto.setCiudadOrigen(servicio.getCiudadOrigen());
            //        servicio.setCostoServicioList(costoServicioList);
                servicioDto.setFechaRealizacion(servicio.getFechaRealizacion());
                servicioDto.setFechaSolicitud(servicio.getFechaSolicitud());
                servicioDto.setFolio(servicio.getFolio());
            //        servicio.setIdCliente(servicioDTO.getIdCliente());
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

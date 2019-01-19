/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Estados;
import com.sgcv.dao.EstadosMunicipios;
import com.sgcv.dao.Municipios;
import com.sgcv.dao.Parametros;
import com.sgcv.dto.EstadosDTO;
import com.sgcv.dto.MunicipiosDTO;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaEstadosDTO;
import com.sgcv.dto.RespuestaMunicipiosDTO;
import com.sgcv.utils.CONSTANTE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class GestorEstadosMunicipiosBean {
    
    public RespuestaEstadosDTO buscarEstados(){
        RespuestaEstadosDTO RespuestaEstadosDTO = new RespuestaEstadosDTO();
        ProcesoDTO proceso = new ProcesoDTO();
        List<EstadosDTO> estadosDTO= new ArrayList();
        try{
            Dao<Estados> dao= new Dao<Estados>(Estados.class);
            List<Estados> estadosEnty = dao.consultaNmed("Estados.findAll");
            for(Estados estadoEnty: estadosEnty){
                EstadosDTO estadoDTO= new EstadosDTO();
                estadoDTO.setEstado(estadoEnty.getEstado());
                estadoDTO.setId(estadoEnty.getId());
                estadosDTO.add(estadoDTO);
                proceso.setResultado(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            proceso.setMensaje("Error al obtener estados "+e.toString()+" : "+e.getLocalizedMessage());
            proceso.setResultado(false);
        }
        RespuestaEstadosDTO.setProceso(proceso);
        RespuestaEstadosDTO.setEstados(estadosDTO);
        return RespuestaEstadosDTO;
    }
    
    
    public RespuestaEstadosDTO buscarMunicipios(String id){
        RespuestaEstadosDTO respuesta = new RespuestaEstadosDTO();
        List<EstadosDTO> estadosDTO = new ArrayList();
        ProcesoDTO proceso = new ProcesoDTO();
        List<Parametros> param= new ArrayList();
        param.add(new Parametros(CONSTANTE.NUMERO,id,"id"));
        try{
            Dao<Estados> dao= new Dao<Estados>(Estados.class);
            List<Estados> estadosEnty = dao.consultaQueryByParametros("Estados.findById",param);
            
            for(Estados estadoEnty: estadosEnty){
//                Municipio
                List<MunicipiosDTO> municipios= new ArrayList();
                EstadosDTO estadoDTO= new EstadosDTO();
                estadoDTO.setId(estadoEnty.getId());
                estadoDTO.setEstado(estadoEnty.getEstado());
                for(EstadosMunicipios em:estadoEnty.getEstadosMunicipiosList()){
                    MunicipiosDTO municipio= new MunicipiosDTO();
                    municipio.setId(em.getMunicipiosId().getId());
                    municipio.setMunicipio(em.getMunicipiosId().getMunicipio());
                    municipios.add(municipio);
                }
                estadoDTO.setMunicipios(municipios);
                estadosDTO.add(estadoDTO);
            }
            proceso.setResultado(true);
        }catch(Exception e){
            e.printStackTrace();
            proceso.setMensaje("Error al obtener munipios "+e.toString()+" : "+e.getLocalizedMessage());
            proceso.setResultado(false);
        }
        respuesta.setProceso(proceso);
        respuesta.setEstados(estadosDTO);
        return respuesta;
    }
    
}

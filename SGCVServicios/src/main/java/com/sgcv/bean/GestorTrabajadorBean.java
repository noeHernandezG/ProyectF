/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Direccion;
import com.sgcv.dao.Parametros;
import com.sgcv.dao.Persona;
import com.sgcv.dao.Trabajador;
import com.sgcv.dto.DireccionDTO;
import com.sgcv.dto.EmpleadoDTO;
import com.sgcv.dto.PersonaDTO;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.RespuestaEmpleadoDTO;
import com.sgcv.utils.CONSTANTE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class GestorTrabajadorBean {
    
    public RespuestaEmpleadoDTO guardarEmpleado(EmpleadoDTO empleado){
        System.out.println("Guardando empleado");
        ProcesoDTO proceso = new ProcesoDTO();
        RespuestaEmpleadoDTO respuesta = new RespuestaEmpleadoDTO();
        try{
            Direccion direccion= new Direccion();
            direccion.setCalle(empleado.getIdDireccion().getCalle());
            direccion.setColonia(empleado.getIdDireccion().getColonia());
            direccion.setCp(empleado.getIdDireccion().getCp());
            direccion.setEntidadFederativa(empleado.getIdDireccion().getEntidadFederativa());
    //        direccion.setIdDireccion(empleado.getIdDireccion().getIdDireccion());
            direccion.setMunicipio(empleado.getIdDireccion().getMunicipio());
            direccion.setNumero(empleado.getIdDireccion().getNumero());

            Persona persona = new Persona();
            persona.setAMaterno(empleado.getIdPersona().getaMaterno());
            persona.setAPaterno(empleado.getIdPersona().getaPaterno());
            persona.setCorreo(empleado.getIdPersona().getCorreo());
            persona.setCurp(empleado.getIdPersona().getCurp());
            persona.setFechaNacimiento(empleado.getIdPersona().getFechaNacimiento());
            persona.setNombre(empleado.getIdPersona().getNombre());
            persona.setRfc(empleado.getIdPersona().getRfc());
            persona.setSexo(empleado.getIdPersona().getSexo());
            persona.setTelefono1(empleado.getIdPersona().getTelefono1());
            persona.setTelefono2(empleado.getIdPersona().getTelefono2());
            persona.setTipoPersona(empleado.getIdPersona().getTipoPersona());

            Trabajador trabajador= new Trabajador();
            trabajador.setFechaIngreso(empleado.getFechaIngreso());
            trabajador.setIdDireccion(direccion);
            trabajador.setIdPersona(persona);
            trabajador.setLocalidadLaboral(empleado.getLocalidadLaboral());
            trabajador.setNssTrabajador(empleado.getNssTrabajador());
            trabajador.setNumeroEmpleado(empleado.getNumeroEmpleado());
            trabajador.setNumeroLicencia(empleado.getNumeroLicencia());
            trabajador.setPeriodicidad(empleado.getPeriodicidad());
            trabajador.setPuesto(empleado.getPuesto());
            trabajador.setRiesgoTrabajo(empleado.getRiesgoTrabajo());
            trabajador.setSindicalizado(empleado.getSindicalizado());
            trabajador.setSueldo(empleado.getSueldo());
            trabajador.setSueldoIntegrado(empleado.getSueldoIntegrado());
            trabajador.setTipoContrato(empleado.getTipoContrato());
            trabajador.setTipoJornada(empleado.getTipoJornada());
            trabajador.setUrlFoto(empleado.getUrlFoto());
            trabajador.setVigenciaLicencia(empleado.getVigenciaLicencia());

            Dao<Trabajador> daoT= new Dao<Trabajador>(Trabajador.class);
            proceso.setResultado( daoT.inserta(trabajador));
            if(proceso.isResultado()){
                proceso.setMensaje("Se registro correctamente el empleado");
            }else{
                proceso.setMensaje("no se pudo registrar al usuario");
            }
        }catch(Exception e){
            proceso.setMensaje("Error al registrar el usuario "+e.toString()+" : "+e.getLocalizedMessage());
            proceso.setResultado(false);
            e.printStackTrace();
        }
        respuesta.setProceso(proceso);
        return respuesta;
    }
    
    public RespuestaEmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado){
        ProcesoDTO proceso = new ProcesoDTO();
        RespuestaEmpleadoDTO respuesta = new RespuestaEmpleadoDTO();
        try{
            Direccion direccion= new Direccion();
            direccion.setCalle(empleado.getIdDireccion().getCalle());
            direccion.setColonia(empleado.getIdDireccion().getColonia());
            direccion.setCp(empleado.getIdDireccion().getCp());
            direccion.setEntidadFederativa(empleado.getIdDireccion().getEntidadFederativa());
            direccion.setIdDireccion(empleado.getIdDireccion().getIdDireccion());
            direccion.setMunicipio(empleado.getIdDireccion().getMunicipio());
            direccion.setNumero(empleado.getIdDireccion().getNumero());

            Persona persona = new Persona();
            persona.setAMaterno(empleado.getIdPersona().getaMaterno());
            persona.setAPaterno(empleado.getIdPersona().getaPaterno());
            persona.setCorreo(empleado.getIdPersona().getCorreo());
            persona.setCurp(empleado.getIdPersona().getCurp());
            persona.setFechaNacimiento(empleado.getIdPersona().getFechaNacimiento());
            persona.setNombre(empleado.getIdPersona().getNombre());
            persona.setRfc(empleado.getIdPersona().getRfc());
            persona.setSexo(empleado.getIdPersona().getSexo());
            persona.setTelefono1(empleado.getIdPersona().getTelefono1());
            persona.setTelefono2(empleado.getIdPersona().getTelefono2());
            persona.setTipoPersona(empleado.getIdPersona().getTipoPersona());
            persona.setIdPersona(empleado.getIdPersona().getIdPersona());

            Trabajador trabajador= new Trabajador();
            trabajador.setFechaIngreso(empleado.getFechaIngreso());
            trabajador.setIdDireccion(direccion);
            trabajador.setIdPersona(persona);
            trabajador.setLocalidadLaboral(empleado.getLocalidadLaboral());
            trabajador.setNssTrabajador(empleado.getNssTrabajador());
            trabajador.setNumeroEmpleado(empleado.getNumeroEmpleado());
            trabajador.setNumeroLicencia(empleado.getNumeroLicencia());
            trabajador.setPeriodicidad(empleado.getPeriodicidad());
            trabajador.setPuesto(empleado.getPuesto());
            trabajador.setRiesgoTrabajo(empleado.getRiesgoTrabajo());
            trabajador.setSindicalizado(empleado.getSindicalizado());
            trabajador.setSueldo(empleado.getSueldo());
            trabajador.setSueldoIntegrado(empleado.getSueldoIntegrado());
            trabajador.setTipoContrato(empleado.getTipoContrato());
            trabajador.setTipoJornada(empleado.getTipoJornada());
            trabajador.setUrlFoto(empleado.getUrlFoto());
            trabajador.setVigenciaLicencia(empleado.getVigenciaLicencia());
            trabajador.setIdTrabajador(empleado.getIdTrabajador());

            Dao<Trabajador> daoT= new Dao<Trabajador>(Trabajador.class);
            proceso.setResultado(daoT.actualiza(trabajador));
            if(proceso.isResultado()){
                proceso.setMensaje("Se modifico correctamente el usuario");
            }else{
                proceso.setMensaje("No se modifico correctamente el usuario");
            }
        }catch(Exception e){
            proceso.setResultado(false);
            proceso.setMensaje("Error al modificar usuario");
        }
        return respuesta;
    }
    
    public RespuestaEmpleadoDTO buscarEmpleado(EmpleadoDTO empleado){
        ProcesoDTO proceso = new ProcesoDTO();
        RespuestaEmpleadoDTO respuesta = new RespuestaEmpleadoDTO();
        List<EmpleadoDTO>trabajadoresDTO = new ArrayList();
        try{
            List<Trabajador> trabajadores= new ArrayList();
            
            Dao<Trabajador> daoT= new Dao<Trabajador>(Trabajador.class);
            trabajadores = daoT.consultaNmed("Trabajador.findAll");
            for(Trabajador trabajador:trabajadores){
                DireccionDTO direccion = new DireccionDTO();
                direccion.setCalle(trabajador.getIdDireccion().getCalle());
                direccion.setColonia(trabajador.getIdDireccion().getColonia());
                direccion.setCp(trabajador.getIdDireccion().getCp());
                direccion.setEntidadFederativa(trabajador.getIdDireccion().getEntidadFederativa());
                direccion.setIdDireccion(trabajador.getIdDireccion().getIdDireccion());
                direccion.setMunicipio(trabajador.getIdDireccion().getMunicipio());
                direccion.setNumero(trabajador.getIdDireccion().getNumero());
                                                
                PersonaDTO persona = new PersonaDTO();
                persona.setCorreo(trabajador.getIdPersona().getCorreo());
                persona.setCurp(trabajador.getIdPersona().getCurp());
                persona.setFechaNacimiento(trabajador.getIdPersona().getFechaNacimiento());
                persona.setIdPersona(trabajador.getIdPersona().getIdPersona());
                persona.setNombre(trabajador.getIdPersona().getNombre());
                persona.setRfc(trabajador.getIdPersona().getRfc());
                persona.setSexo(trabajador.getIdPersona().getSexo());
                persona.setTelefono1(trabajador.getIdPersona().getTelefono1());
                persona.setTelefono2(trabajador.getIdPersona().getTelefono2());
                persona.setTipoPersona(trabajador.getIdPersona().getTipoPersona());
                persona.setaMaterno(trabajador.getIdPersona().getAMaterno());
                persona.setaPaterno(trabajador.getIdPersona().getAPaterno());                                
                
                EmpleadoDTO empleadoDTO= new EmpleadoDTO();
                empleadoDTO.setFechaIngreso(trabajador.getFechaIngreso());
                empleadoDTO.setIdTrabajador(trabajador.getIdTrabajador());
                empleadoDTO.setLocalidadLaboral(trabajador.getLocalidadLaboral());
                empleadoDTO.setNssTrabajador(trabajador.getNssTrabajador());
                empleadoDTO.setNumeroEmpleado(trabajador.getNumeroEmpleado());
                empleadoDTO.setNumeroLicencia(trabajador.getNumeroLicencia());
                empleadoDTO.setPeriodicidad(trabajador.getPeriodicidad());
                empleadoDTO.setPuesto(trabajador.getPuesto());
                empleadoDTO.setRiesgoTrabajo(trabajador.getRiesgoTrabajo());
                empleadoDTO.setSindicalizado(trabajador.getSindicalizado());
                empleadoDTO.setSueldo(trabajador.getSueldo());
                empleadoDTO.setSueldoIntegrado(trabajador.getSueldoIntegrado());
                empleadoDTO.setTipoContrato(trabajador.getTipoContrato());
                empleadoDTO.setTipoJornada(trabajador.getTipoJornada());
                empleadoDTO.setUrlFoto(trabajador.getUrlFoto());
                empleadoDTO.setVigenciaLicencia(trabajador.getVigenciaLicencia());
                
                empleadoDTO.setIdPersona(persona);
                empleadoDTO.setIdDireccion(direccion);
                
                trabajadoresDTO.add(empleadoDTO);
            }
            proceso.setResultado(true);
            
            respuesta.setEmpleado(trabajadoresDTO);
            if(proceso.isResultado()){
                proceso.setMensaje("proceso correcto");
            }else{
                proceso.setMensaje("no se pudo buscar usuarios");
            }
        }catch(Exception e){
            proceso.setResultado(false);
            proceso.setMensaje("Error al consultar usuarios");
        }
        respuesta.setEmpleado(trabajadoresDTO);
        respuesta.setProceso(proceso);
        return respuesta;
    }
    
    public RespuestaEmpleadoDTO eliminarEmpleado(EmpleadoDTO empleado){
        return new RespuestaEmpleadoDTO();
    }
    
    
    public RespuestaEmpleadoDTO buscarEmpleadoById(EmpleadoDTO empleado){
        ProcesoDTO proceso = new ProcesoDTO();
        RespuestaEmpleadoDTO respuesta = new RespuestaEmpleadoDTO();
        List<EmpleadoDTO>trabajadoresDTO = new ArrayList();
        try{
            List<Trabajador> trabajadores= new ArrayList();
            
            Dao<Trabajador> daoT= new Dao<Trabajador>(Trabajador.class);
            List<Parametros> parametros= new ArrayList();
            parametros.add(new Parametros(CONSTANTE.NUMERO,empleado.getIdTrabajador().toString(),"idTrabajador"));
            trabajadores = daoT.consultaQueryByParametros("Trabajador.findByIdTrabajador",parametros);
            for(Trabajador trabajador:trabajadores){
                DireccionDTO direccion = new DireccionDTO();
                direccion.setCalle(trabajador.getIdDireccion().getCalle());
                direccion.setColonia(trabajador.getIdDireccion().getColonia());
                direccion.setCp(trabajador.getIdDireccion().getCp());
                direccion.setEntidadFederativa(trabajador.getIdDireccion().getEntidadFederativa());
                direccion.setIdDireccion(trabajador.getIdDireccion().getIdDireccion());
                direccion.setMunicipio(trabajador.getIdDireccion().getMunicipio());
                direccion.setNumero(trabajador.getIdDireccion().getNumero());
                                                
                PersonaDTO persona = new PersonaDTO();
                persona.setCorreo(trabajador.getIdPersona().getCorreo());
                persona.setCurp(trabajador.getIdPersona().getCurp());
                persona.setFechaNacimiento(trabajador.getIdPersona().getFechaNacimiento());
                persona.setIdPersona(trabajador.getIdPersona().getIdPersona());
                persona.setNombre(trabajador.getIdPersona().getNombre());
                persona.setRfc(trabajador.getIdPersona().getRfc());
                persona.setSexo(trabajador.getIdPersona().getSexo());
                persona.setTelefono1(trabajador.getIdPersona().getTelefono1());
                persona.setTelefono2(trabajador.getIdPersona().getTelefono2());
                persona.setTipoPersona(trabajador.getIdPersona().getTipoPersona());
                persona.setaMaterno(trabajador.getIdPersona().getAMaterno());
                persona.setaPaterno(trabajador.getIdPersona().getAPaterno());                                
                
                EmpleadoDTO empleadoDTO= new EmpleadoDTO();
                empleadoDTO.setFechaIngreso(trabajador.getFechaIngreso());
                empleadoDTO.setIdTrabajador(trabajador.getIdTrabajador());
                empleadoDTO.setLocalidadLaboral(trabajador.getLocalidadLaboral());
                empleadoDTO.setNssTrabajador(trabajador.getNssTrabajador());
                empleadoDTO.setNumeroEmpleado(trabajador.getNumeroEmpleado());
                empleadoDTO.setNumeroLicencia(trabajador.getNumeroLicencia());
                empleadoDTO.setPeriodicidad(trabajador.getPeriodicidad());
                empleadoDTO.setPuesto(trabajador.getPuesto());
                empleadoDTO.setRiesgoTrabajo(trabajador.getRiesgoTrabajo());
                empleadoDTO.setSindicalizado(trabajador.getSindicalizado());
                empleadoDTO.setSueldo(trabajador.getSueldo());
                empleadoDTO.setSueldoIntegrado(trabajador.getSueldoIntegrado());
                empleadoDTO.setTipoContrato(trabajador.getTipoContrato());
                empleadoDTO.setTipoJornada(trabajador.getTipoJornada());
                empleadoDTO.setUrlFoto(trabajador.getUrlFoto());
                empleadoDTO.setVigenciaLicencia(trabajador.getVigenciaLicencia());
                
                empleadoDTO.setIdPersona(persona);
                empleadoDTO.setIdDireccion(direccion);
                
                trabajadoresDTO.add(empleadoDTO);
            }
            proceso.setResultado(true);
            
            respuesta.setEmpleado(trabajadoresDTO);
            if(proceso.isResultado()){
                proceso.setMensaje("proceso correcto");
            }else{
                proceso.setMensaje("no se pudo buscar usuarios");
            }
        }catch(Exception e){
            proceso.setResultado(false);
            proceso.setMensaje("Error al consultar usuarios");
        }
        respuesta.setEmpleado(trabajadoresDTO);
        respuesta.setProceso(proceso);
        return respuesta;
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
        GestorTrabajadorBean gestor = new GestorTrabajadorBean();
        gestor.guardarEmpleado(empleado);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Direccion;
import com.sgcv.dao.Persona;
import com.sgcv.dao.Trabajador;
import com.sgcv.dto.DireccionDTO;
import com.sgcv.dto.EmpleadoDTO;
import com.sgcv.dto.RespuestaEmpleadoDTO;

/**
 *
 * @author Ernesto
 */
public class GestorTrabajadorBean {
    
    public RespuestaEmpleadoDTO guardarEmpleado(EmpleadoDTO empleado){
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
        boolean resultT = daoT.inserta(trabajador);
        return new RespuestaEmpleadoDTO();
    }
    
    public RespuestaEmpleadoDTO actualizarEmpleado(EmpleadoDTO empleado){
        return new RespuestaEmpleadoDTO();
    }
    
    public RespuestaEmpleadoDTO buscarEmpleado(EmpleadoDTO empleado){
        return new RespuestaEmpleadoDTO();
    }
    
    public RespuestaEmpleadoDTO eliminarEmpleado(EmpleadoDTO empleado){
        return new RespuestaEmpleadoDTO();
    }
    
    public static void main(String[] args) {
        EmpleadoDTO empleado= new EmpleadoDTO();
        DireccionDTO direccion= new DireccionDTO();
        direccion.setCalle("afsdd");
        direccion.setColonia("afsdd");
        direccion.setCp("afsdd");
        direccion.setEntidadFederativa("afsdd");
//        direccion.setIdDireccion(1);
        direccion.setMunicipio("afsdd");
        direccion.setNumero(1);
        empleado.setIdDireccion(direccion);
        empleado.setFechaIngreso("12-11-2018");
//        empleado.setFechaIngreso("12-11-2010");
        GestorTrabajadorBean gestor = new GestorTrabajadorBean();
        gestor.guardarEmpleado(empleado);
    }
}

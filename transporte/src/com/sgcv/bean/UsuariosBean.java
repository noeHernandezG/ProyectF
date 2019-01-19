/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.google.gson.Gson;
import com.sgcv.dto.ProcesoDTO;
import com.sgcv.dto.UsuarioDTO;
import com.sgcv.utils.ClienteREST;

/**
 *
 * @author Ernesto
 */
public class UsuariosBean {
    private String url="http://192.168.56.1:7001/SGCVServicios/resources/gestorUsuariosWS/insertarUsuario"; 
    private String urlLogin="http://192.168.56.1:7001/SGCVServicios/resources/gestorUsuariosWS/login"; 
    private String metodo="POST";
    private Gson gson;
    
    public String registrarUsuario(UsuarioDTO usuario){
        gson=new Gson();
        String request=gson.toJson(usuario);
        System.out.println(request);
        ClienteREST cliente=new ClienteREST();
        String response=cliente.getResponse(url, metodo, request);
        System.out.println(response);
        return response;
    }
    
    public boolean loginUsuario(UsuarioDTO usuario){
        gson=new Gson();
        String request=gson.toJson(usuario);
        System.out.println(request);
        ClienteREST cliente=new ClienteREST();
        String response=cliente.getResponse(urlLogin, metodo, request);
        System.out.println(response);
        if(response.contains("Total : 1")){
            return true;
        }else{
            return false;
        }
    }
    public boolean validaContraseña(String contraseña){
        return  contraseña.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
    }
    
    public boolean validaCorreo(String correo){
        return correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
    }
    
    public boolean validaUsuario(String usuario){
        boolean valido = true;
            
        return valido;
    }
    
    public static void main(String[] args) {
        UsuariosBean usuarios=new UsuariosBean();
        System.out.println(usuarios.validaCorreo(""));
    }
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.bean;

import com.sgcv.dao.Dao;
import com.sgcv.dao.Parametros;
import com.sgcv.dao.Usuario;
import com.sgcv.dto.UsuarioDTO;
import com.sgcv.utils.CONSTANTE;
import com.sgcv.utils.Encrypt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ernesto
 */
public class GestorUsuariosBean {
    
    public String insertaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario= new Usuario();
        usuario.setClave(usuarioDTO.getClave());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setNombre(usuarioDTO.getNombre());
        Dao<Usuario> dao= new Dao<Usuario>(Usuario.class);
        boolean result = dao.inserta(usuario);
        System.out.println("Total "+result);
        return ""+result;
    }
    
    public String modificaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario= new Usuario();
        usuario.setClave(usuarioDTO.getClave());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setId(usuarioDTO.getId());
        Dao<Usuario> dao= new Dao<Usuario>(Usuario.class);
        boolean result = dao.actualiza(usuario);
        System.out.println("Total "+result);
        return ""+result;
    }
    
//    public String consultaUsuarioById(String idUsuario){
//        Usuario usuario= new Usuario();
//        usuario.setClave(usuarioDTO.getClave());
//        usuario.setCorreo(usuarioDTO.getCorreo());
////        usuario.setId(Integer.SIZE);
//        usuario.setNombre(usuarioDTO.getNombre());
//        Dao<Usuario> dao= new Dao<Usuario>(Usuario.class);
//        boolean result = dao.inserta(usuario);
//        System.out.println("Total "+result);
//        return ""+result;
//    }
    
    public String eliminaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario= new Usuario();
        usuario.setClave(usuarioDTO.getClave());
        usuario.setCorreo(usuarioDTO.getCorreo());
//        usuario.setId(Integer.SIZE);
        usuario.setNombre(usuarioDTO.getNombre());
        Dao<Usuario> dao= new Dao<Usuario>(Usuario.class);
        boolean result = dao.inserta(usuario);
        System.out.println("Total "+result);
        return ""+result;
    }
    
    public String login(UsuarioDTO usuarioDTO){
        String user=usuarioDTO.getNombre();
        String pass=usuarioDTO.getClave();
        List<Usuario> usuarios=null;
        try {
            List<Parametros> parametros= new ArrayList<>();
            parametros.add(new Parametros(CONSTANTE.CADENA,user,"nombre"));
//            parametros.add(new Parametros(CONSTANTE.CADENA,pass,":clave"));
//            String passEncrypt = new Encrypt().encryptText(pass);
            System.out.println("passEncrypt = "+pass);
            parametros.add(new Parametros(CONSTANTE.CADENA,pass,"clave"));
            Dao<Usuario> dao= new Dao<Usuario>(Usuario.class);
            usuarios=dao.consultaQueryByParametros("Usuario.findByClaveAndUser", parametros);
            System.out.println("Total encontrado = "+usuarios.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Se encontraron "+usuarios.size();
    }
}

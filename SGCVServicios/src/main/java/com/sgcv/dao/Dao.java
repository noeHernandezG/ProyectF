/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dao;

import com.sgcv.utils.CONSTANTE;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ernesto
 */
public class Dao<T> {
//    com.microsoft.sqlserver.jdbc.SQLServerDriver
    private EntityManager em;
    private EntityManagerFactory emf; //= Persistence.createEntityManagerFactory("Portal_CUSTFPU");
    private EntityTransaction et;
    private Class<T> entidad;
    
    public Dao(Class<T> claseEntidad) {
        this.entidad = claseEntidad;
    }
    
    
    public  List<T> consulta(String query){
        List<T> result=null;
        try{
            createEMF();
            result= em.createQuery(query).getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeEMF();
        }
        return result;
    } 
    
    
    public boolean inserta(T entity){
        
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al insertar "+entidad.getName());
        }finally{
            closeEMF();
        }
        return false;
    }   
    
    public List<T> consultaQueryByParametros (String query, List<Parametros> parametros){
        List<T> listadoEntidad= null;
        try{
            createEMF();
            
            Query q = em.createNamedQuery(query);
            for(Parametros parametro: parametros){
                if (CONSTANTE.CADENA.equals(parametro.getTipo())) {
                    q.setParameter(parametro.getNombre(),parametro.getValor());
                }
                if (CONSTANTE.NUMERO.equals(parametro.getTipo())) {
                    q.setParameter(parametro.getNombre(), Integer.parseInt(parametro.getValor()));
                }
            }
//        Object resultado = em.createQuery(query).getResultList();
//        List<T> listEntity=(List<T>) resultado;
            Object resultado = q.getResultList();
            listadoEntidad = (List<T>) resultado;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeEMF();
        }
        return listadoEntidad;
    }
    
    public boolean actualiza(T entity){
        boolean result = true;
        try{
            createEMF();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Error al insertar "+entidad.getName());
            result = false;
        }finally{
            closeEMF();
        }
        return result;
    }
    
    public boolean elimina(T entity){
         boolean result = true;
        try{
            createEMF();
            em.getTransaction().begin();
            entity = (T) em.find(entity.getClass(), 3);
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al eliminar "+entidad.getName());
            result = false;
        }finally{
            closeEMF();
        }
        return result;
    }
    
    public void createEMF(){
        emf = Persistence.createEntityManagerFactory("SGCV_DS");
        em = emf.createEntityManager();
    }
    
    public void closeEMF(){
        em.close();
        emf.close();
    }
    
    public static void main(String[] args) {
        Dao<Usuario> dao= new Dao<Usuario>(Usuario.class);
        List<Usuario> users = dao.consulta("select u FROM Usuario u");
        System.out.println("Total "+users.size());
    }
}

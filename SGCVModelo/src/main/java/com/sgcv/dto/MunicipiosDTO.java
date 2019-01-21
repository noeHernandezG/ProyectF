/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.dto;

/**
 *
 * @author Ernesto
 */
public class MunicipiosDTO implements Comparable<MunicipiosDTO>{
    
    private Integer id;
    private String municipio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    
//    @Override
//    public int compareTo(MunicipiosDTO o) {
//        if (((int)municipio.charAt(0)) < ((int)o.municipio.charAt(0))) {
//                return -1;
//            }
//        if (((int)municipio.charAt(0)) < ((int)o.municipio.charAt(0))) {
//                return 1;
//            }
//            return 0;
//    }

    @Override
    public int compareTo(MunicipiosDTO o) {
        String a=new String(this.getMunicipio());
        String b=new String(o.getMunicipio());
        return a.compareTo(b);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.utils;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author Ernesto
 */
public class Encrypt {
    
    public String encryptText(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        byte[] digest = md.digest();
        
        byte[] encoded = Base64.encodeBase64(digest);
        return new String(encoded);
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("");
            Encrypt e= new Encrypt();
            System.out.println(e.encryptText("1234"));
        } catch (Exception ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

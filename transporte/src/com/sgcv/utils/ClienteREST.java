/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgcv.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Ernesto
 */
public class ClienteREST {
    
    public void getResponse(String url,String method,String request){
        try{
            URL urlREST = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlREST.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");
//            
            OutputStream os = conn.getOutputStream();
            os.write(request.getBytes());
            os.flush();
            
            if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                    System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
              e.printStackTrace();
        } catch (IOException e) {
              e.printStackTrace();

        }
    }
    
    public static void main(String[] args) {
        String request= "{\n" +
"	\"id\":1,\n" +
"	\"nombre\":\"user1\",\n" +
"    \"correo\":\"correogmail.com\",\n" +
"    \"clave\":\"==\"\n" +
"}";
        ClienteREST cliente= new ClienteREST();
        cliente.getResponse("http://192.168.56.1:7001/SGCVServicios/resources/gestorUsuariosWS/login",
                "POST", request);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author vinicius
 */
class DefaultService {

    private URL url;

    public DefaultService() throws Exception {
        this.url = new URL("http://localhost:8080");
    }

    public DefaultService(URL url) {
        this.url = url;
    }

    public String get() throws Exception {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        String strJson = "";
        while ((output = br.readLine()) != null) {
            strJson += output;
        }
        conn.disconnect();
       
        return strJson;
    }
}

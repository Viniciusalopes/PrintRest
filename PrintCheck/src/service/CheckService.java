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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author vinicius
 */
public class CheckService {

    private static int HTTP_COD_SUCESSO = 200;

    public static JSONObject getCheck() throws Exception {
        URL url = new URL("http://localhost:8080");//your url i.e fetch data from .
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

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(strJson);
        System.out.println(json.toJSONString());
        return json;
    }
}

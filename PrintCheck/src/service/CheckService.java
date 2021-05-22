/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author vinicius
 */
public class CheckService {

    private DefaultService ds;
    private JSONParser parser = new JSONParser();

    public CheckService() throws Exception {
        ds = new DefaultService(new URL("http://localhost:8080"));
    }

    public Object[] getChecks() throws Exception {
        String get = ds.get();
        String[] checks = get.replace("[", "").replace("]", "").replace("},", "}-->").split("-->");
        Object[] ret = new Object[checks.length];

        for (int i = 0; i < checks.length; i++) {
            JSONObject joc = new JSONObject();
            joc = (JSONObject) parser.parse(checks[i]);

            ret[i] = new Object[]{
                joc.get("id"),
                joc.get("registration"),
                joc.get("rg"),
                joc.get("number"),
                joc.get("value"),
                joc.get("written_value"),
                joc.get("associate_name"),
                joc.get("date"),
                joc.get("limit_per_sheet"),
                joc.get("validity"),
                getPrints(Integer.parseInt(joc.get("id").toString()))
            };
        }
        return ret;
    }

    private JSONObject getJsonPrints(int id) throws Exception {
        JSONObject ret = new JSONObject();
        try {
            ret = (JSONObject) parser.parse(FileService.load("checkPrint", id + "", "json"));
        } catch (Exception e) {
            ret.put("prints", 0);
        }
        return ret;
    }

    private int getPrints(int id) throws Exception {
        JSONObject jop = getJsonPrints(id);
        return Integer.parseInt(jop.get("prints").toString());
    }

    public void addPrint(int id) throws Exception {
        JSONObject ret = new JSONObject();
        ret.put("prints", (getPrints(id) + 1));
        FileService.record("checkPrint", id + "", "json", ret.toJSONString());
    }
}

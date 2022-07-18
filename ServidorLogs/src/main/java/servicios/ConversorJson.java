/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import com.google.gson.Gson;
import modelo.Sensor;
/**
 *
 * @author Paula
 */
public class ConversorJson {
    public static String objectToJson(InformacionDTO information){
        Gson gson = new Gson();
        String response;
        response = gson.toJson(information);
        return response;
    }
    public static Sensor JsonToObject(String json){
        Gson gson = new Gson();
        Sensor response = new Sensor();
        response = gson.fromJson(json, Sensor.class);
        return response;
    }
}

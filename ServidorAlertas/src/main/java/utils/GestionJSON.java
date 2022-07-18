package utils;


import com.google.gson.Gson;
import model.InformacionDTO;
import model.sensores.Sensor;

public class GestionJSON {
    public static InformacionDTO JsonToObject(String json){
        Gson gson = new Gson();
        InformacionDTO response = new InformacionDTO();
        response = gson.fromJson(json, InformacionDTO.class);
        return response;
    }
    
    
    public static String objectToJson(Sensor information){
        Gson gson = new Gson();
        String response;
        response = gson.toJson(information);
        return response;
    }
}

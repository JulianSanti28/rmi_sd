package utils;


import com.google.gson.Gson;
import model.InformacionDTO;

public class GestionJSON {
    public static InformacionDTO JsonToObject(String json){
        Gson gson = new Gson();
        InformacionDTO response = new InformacionDTO();
        response = gson.fromJson(json, InformacionDTO.class);
        return response;
    }
}

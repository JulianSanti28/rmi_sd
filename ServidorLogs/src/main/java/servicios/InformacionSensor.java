/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.Date;

/**
 *
 * @author Paula
 */
public class InformacionSensor {
    public static String atenderPeticion(String sensor){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        InformacionDTO informacion = new InformacionDTO();
        informacion.setFecha(new Date());
        informacion.setNombreSensor(sensor);
        
        return ConversorJson.objectToJson(informacion);
    }
}

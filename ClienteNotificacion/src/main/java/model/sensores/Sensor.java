package model.sensores;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public abstract class Sensor implements Serializable {
    //Atributos
    private String nombre;
    private double lectura;
    private String unidades;

    //Constructor
    public Sensor(String nombre, String unidades){
        this.nombre = nombre;
        this.unidades = unidades;
    }
    //Métodos
    public abstract void leerSensor();
}

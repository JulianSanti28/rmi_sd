/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sensores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author 57322
 */
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

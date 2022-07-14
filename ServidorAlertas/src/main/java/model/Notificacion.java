package model;

import lombok.Data;
import model.sensores.Sensor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Notificacion implements Serializable {
    private int numeroHabitacion;
    private ArrayList<Sensor> sensoresFueraRango;
    public Notificacion(int numeroHabitacion, ArrayList<Sensor> sensores){
        this.sensoresFueraRango = new ArrayList<>();
        this.sensoresFueraRango = sensores;
        this.numeroHabitacion = numeroHabitacion;
    }
}

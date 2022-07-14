package model;

import lombok.Data;
import model.sensores.Sensor;

import java.io.Serializable;
import java.util.ArrayList;

@Data

public class SensoresDTO implements Serializable {
    private int numeroHabitacion;
    private ArrayList<Sensor> sensores;

    /*Constructor*/
    public SensoresDTO() {
        this.sensores = new ArrayList<>();
    }
}


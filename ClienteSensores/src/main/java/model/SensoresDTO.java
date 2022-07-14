package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.sensores.*;

import java.io.Serializable;
import java.util.ArrayList;
@Data
public class SensoresDTO implements Serializable {

    /*Constructor*/
    public SensoresDTO(){
        this.sensores = new ArrayList<>();
    }
    private int numeroHabitacion;
    private ArrayList<Sensor> sensores;
}

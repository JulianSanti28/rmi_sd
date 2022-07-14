package model.sensores;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class SensorFrecuenciaCardiaca extends Sensor implements Serializable {

    //Constructor
    public SensorFrecuenciaCardiaca(String nombre, String unidades) {
        super(nombre, unidades);
    }



    @Override
    public void leerSensor() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\t\t\tSENSOR FRECUENCIA CARDIACA \nDigite valor de " + this.getNombre() + " en " + this.getUnidades());
        this.setLectura(entrada.nextDouble());
        entrada.nextLine();
    }
}

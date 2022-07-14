package model.sensores;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class SensorFrecuenciaRespiratoria extends Sensor implements Serializable {
    //Constructor
    public SensorFrecuenciaRespiratoria(String nombre, String unidades) {
        super(nombre, unidades);
    }

    @Override
    public void leerSensor() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\t\t\tSENSOR FRECUENCIA RESPIRATORIA \nDigite valor de " + this.getNombre() + " en " + this.getUnidades());
        this.setLectura(entrada.nextDouble());
        entrada.nextLine();
    }
}

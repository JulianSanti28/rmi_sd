package model.sensores;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class SensorTemperatura extends Sensor implements Serializable {
    //Constructor
    public SensorTemperatura(String nombre, String unidades) {
        super(nombre, unidades);
    }

    @Override
    public void leerSensor() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite valor de " + this.getNombre() + "con unidades " + this.getUnidades().toString());
        this.setLectura(entrada.nextDouble());
        entrada.nextLine();
    }
}
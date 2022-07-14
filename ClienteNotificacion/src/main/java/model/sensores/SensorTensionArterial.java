package model.sensores;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class SensorTensionArterial extends Sensor implements Serializable {
    //Atirbutos
    private double presionSistolica;
    private double presioDistolica;
    //Constructor
    public SensorTensionArterial(String nombre, String unidades) {
        super(nombre, unidades);
    }
    @Override
    public void leerSensor() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite valor de " + this.getNombre() + "para : Presión Sistólica" + "con unidades " + this.getUnidades().toString());
        this.setPresionSistolica(entrada.nextDouble());
        entrada.nextLine();
        System.out.println("Digite valor de " + this.getNombre() + "para : Presión Distólica" + "con unidades " + this.getUnidades().toString());
        this.setPresioDistolica(entrada.nextDouble());
        entrada.nextLine();
    }
}

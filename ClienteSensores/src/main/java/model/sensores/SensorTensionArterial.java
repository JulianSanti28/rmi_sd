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
        System.out.println("\t\t\tSENSOR TENSIÓN ARTERIAL");
        System.out.println("Digite valor de " + this.getNombre() + " sistóloca en " + this.getUnidades());
        this.setPresionSistolica(entrada.nextDouble());
        entrada.nextLine();
        System.out.println("Digite valor de " + this.getNombre() + " distólica en " + this.getUnidades());
        this.setPresioDistolica(entrada.nextDouble());
        entrada.nextLine();
    }
}

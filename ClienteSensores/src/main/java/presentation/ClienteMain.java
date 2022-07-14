package presentation;

import model.IGestionSensores;
import model.SensoresDTO;
import model.sensores.*;
import utils.UtilidadesRegistroCliente;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteMain {

    /*Objeto remoto*/
    private static IGestionSensores objRemoto;
    static Scanner entrada = new Scanner(System.in);
    public static void main(String args[]){
        //Puerto e Ip del servidor de alertas
        int puertoRmiRegistry = 2020;
        String direccionIp = "localhost";
        objRemoto = (IGestionSensores) UtilidadesRegistroCliente.findRemoteObject(direccionIp,puertoRmiRegistry, "gestionSensores");

        if(objRemoto != null){
            while(true) {
                System.out.println("1. Registrar datos sensores \n2. Salir");
                int opc = entrada.nextInt();
                switch (opc){
                    case 1:
                        enviarLecturaSensores();
                    break;
                    case 2:
                        System.exit(1);
                        break;
                }

            }
        }else{
            System.out.println("No se logró obtener el objeto remoto");
        }
    }
    public static void enviarLecturaSensores(){
        try {
            ArrayList<Sensor> sensores = new ArrayList<>();
            Sensor sensorTemperatura = new SensorTemperatura("temperatura", "grados centigrados");
            Sensor sensorOxigeno = new SensorSaturacionOxigeno("oxigeno", "porcentaje");
            Sensor sensorTension = new SensorTensionArterial("tensión", "unidades");
            Sensor sensorFrecuenciaRespiratoria= new SensorFrecuenciaRespiratoria("frecuencia respiratoria", "ventilaciones por minuto");
            Sensor sensorFrecuenciaCardiaca = new SensorFrecuenciaCardiaca("frecuencia cardiaca", "latidos por minuto");
            sensores.add(sensorTemperatura);
            sensores.add(sensorOxigeno);
            sensores.add(sensorTension);
            sensores.add(sensorFrecuenciaRespiratoria);
            sensores.add(sensorFrecuenciaCardiaca);
            SensoresDTO send = new SensoresDTO();
            System.out.println("\t\tDigite número de la habitación: ");
            int nroHabitacion = entrada.nextInt();
            send.setNumeroHabitacion(nroHabitacion);
            entrada.nextLine();
            /*Hacer lectura de sensores*/
            for (Sensor s : sensores){
                s.leerSensor();
            }
            send.setSensores(sensores);
            boolean isCorrect = objRemoto.registrarLecturaSensores(send);
            if (isCorrect){
                System.out.println("Información enviada.");
            }else{
                System.out.println("Información no enviada. \n\n");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import model.sensores.Sensor;
import model.sensores.SensorTensionArterial;
import utils.UtilidadesRegistroNotificacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConexionClienteServLogs;


public class GestionSensoresImpl extends UnicastRemoteObject implements  IGestionSensores{
    
    ConexionClienteServLogs cliente ;
    InformacionDTO informacion ;
    /*Medio de Almacenamiento*/
    public GestionSensoresImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean registrarLecturaSensores(SensoresDTO save) throws RemoteException {
        if (save.getSensores().size() == 5){
            try {
                validarSensores(save.getNumeroHabitacion(),save.getSensores());
                return true;
            } catch (IOException ex) {
                Logger.getLogger(GestionSensoresImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean validarSensores(int habitacion, ArrayList<Sensor> sensores) throws IOException{
        ArrayList<Sensor> lstSensoresFueraRango = new ArrayList<>();
        int sensoresFueraRango = 0;
        for(Sensor s: sensores){
            if(!(s.getNombre().equalsIgnoreCase("tensión")) ){
                if(s.getLectura()<=0){
                    escribirLog(s);
                }
                
            }else{
                SensorTensionArterial sensorTension = (SensorTensionArterial) s;
                if((sensorTension.getPresionSistolica()<=0 ) ||(sensorTension.getPresioDistolica() <=0)){
                    
                    escribirLog(sensorTension);
                }
           
            }
            switch (s.getNombre()){
                case "oxigeno":
                    if(s.getLectura()>=95 && s.getLectura()<=100){
                        break;
                    }
                    
                    lstSensoresFueraRango.add(s);
                    sensoresFueraRango++;
                    break;
                case "temperatura":
                    if(s.getLectura()>=36.2 && s.getLectura()<=37.2){
                        break;
                    }
                    lstSensoresFueraRango.add(s);
                    sensoresFueraRango++;
                    break;
                case "tensión":
                    SensorTensionArterial sensorTension = (SensorTensionArterial) s;
                    if((sensorTension.getPresionSistolica()>=110 && sensorTension.getPresionSistolica()<=140) && sensorTension.getPresioDistolica() >= 70 && sensorTension.getPresioDistolica()<=90){
                        break;
                    }
                    lstSensoresFueraRango.add(s);
                    sensoresFueraRango++;
                    break;
                case "frecuencia respiratoria":
                    if(s.getLectura()>=12 && s.getLectura()<=20){
                        break;
                    }
                    lstSensoresFueraRango.add(s);
                    sensoresFueraRango++;
                    break;
                case "frecuencia cardiaca":
                    if(s.getLectura()>=60 && s.getLectura()<=80){
                       break;
                    }
                    lstSensoresFueraRango.add(s);
                    sensoresFueraRango++;
                    break;
            }
        }
        if (sensoresFueraRango >= 2){
            //Envíar reporte al de notificaciones
            /*Objeto remoto*/
            IGestionNotificacion objRemotoNotificacion;
            int puertoRmiRegistry = 2020;
            String direccionIp = "localhost";
            objRemotoNotificacion = (IGestionNotificacion) UtilidadesRegistroNotificacion.findRemoteObject(direccionIp,puertoRmiRegistry, "gestionNotificacion");
            if (objRemotoNotificacion != null){
                Notificacion notificacion = new Notificacion(habitacion, lstSensoresFueraRango);
                try {
                    System.out.println("Enviando Notificación...");
                    objRemotoNotificacion.enviarNotificacion(notificacion);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        return true;
    }
    public void escribirLog(Sensor s ) throws IOException{
        cliente = new ConexionClienteServLogs();
        informacion = new InformacionDTO();
        try {
            cliente.ServerConnection("localhost",2024);
        } catch(Exception e){
            System.out.println("\nError: "+e.getMessage());
        } 
        System.out.println("Enviando error a log..");
        informacion = cliente.peticion_respuesta(s);
        
        
        
    }
    
    
}

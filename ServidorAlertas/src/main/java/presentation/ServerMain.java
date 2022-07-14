package presentation;

import model.GestionNotificacionImpl;
import model.GestionSensoresImpl;
import model.IGestionNotificacion;
import model.IGestionSensores;
import utils.UtilidadesRegistroServidor;

import java.rmi.RemoteException;

public class ServerMain {

    public static void main(String args[]) throws RemoteException {
        int puertoRmiRegistry = 2020;
        String direccionIp = "localhost";
        IGestionSensores objRemoto = new GestionSensoresImpl();
        IGestionNotificacion objRemotoNotificacion = new GestionNotificacionImpl();
        try
        {
            UtilidadesRegistroServidor.initNs(puertoRmiRegistry);
            UtilidadesRegistroServidor.RegistrarObjetoRemoto(objRemoto, direccionIp, puertoRmiRegistry, "gestionSensores");
            UtilidadesRegistroServidor.RegistrarObjetoRemoto(objRemotoNotificacion,direccionIp, puertoRmiRegistry, "gestionNotificacion");
            System.out.println("Alerts Server Running...");
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}

package presentation;

import model.ClienteNotificacionImpl;
import model.IClienteNotificacion;
import model.IGestionNotificacion;
import utils.UtilidadesRegistroNotificacion;

import java.rmi.RemoteException;

public class NotificacionMain {

    /*Objeto remoto*/
    private static IGestionNotificacion objRemoto;

    public static void main(String args[]){
        int puertoRmiRegistry = 2020;
        String direccionIp = "localhost";
        objRemoto = (IGestionNotificacion) UtilidadesRegistroNotificacion.findRemoteObject(direccionIp,puertoRmiRegistry, "gestionNotificacion");
        System.out.println("Esperando notificaciones...");
        try {
            IClienteNotificacion cliente = new ClienteNotificacionImpl();
            objRemoto.registrarUsuarioNotificacion(cliente);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

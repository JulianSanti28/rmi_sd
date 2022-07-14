package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClienteNotificacionImpl extends UnicastRemoteObject implements IClienteNotificacion {

    public  ClienteNotificacionImpl() throws RemoteException {
        super();
    }
    @Override
    public void notificar(Notificacion mensaje) throws RemoteException {
        System.out.println("Mensaje recibido: " + mensaje.getSensoresFueraRango().size());
    }
}

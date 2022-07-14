package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClienteNotificacion extends Remote {
    public void notificar(Notificacion mensaje) throws RemoteException;
}

package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGestionNotificacion extends Remote {
    public boolean registrarUsuarioNotificacion(IClienteNotificacion cliente) throws RemoteException;
    public void enviarNotificacion(Notificacion mensaje) throws RemoteException;
}
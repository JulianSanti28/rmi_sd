package model;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class GestionNotificacionImpl  extends UnicastRemoteObject implements IGestionNotificacion {
    private ArrayList<IClienteNotificacion> clientes;
    public GestionNotificacionImpl() throws RemoteException {
        super();
        this.clientes = new ArrayList<>();
    }

    @Override
    public synchronized boolean registrarUsuarioNotificacion(IClienteNotificacion cliente) throws RemoteException{
        System.out.println("Registrando cliente notificaciones...");
        if(!this.clientes.contains(cliente)){
            return this.clientes.add(cliente);
        }
        return false;
    }

    @Override
    public void enviarNotificacion(Notificacion mensaje) throws RemoteException{
        for (IClienteNotificacion c: this.clientes) {
            c.notificar(mensaje);
        }
    }
}

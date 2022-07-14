package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGestionSensores extends Remote {
    public boolean registrarLecturaSensores(SensoresDTO save) throws RemoteException;
}

package utils;

import java.rmi.Naming;
import java.rmi.Remote;

public class UtilidadesRegistroNotificacion {
    public static Remote findRemoteObject(String ip, int puerto, String nameObjReg) {
        String URLRegistro;
        URLRegistro  = "rmi://" + ip + ":" + puerto + "/"+nameObjReg;
        try
        {
            return Naming.lookup(URLRegistro);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}

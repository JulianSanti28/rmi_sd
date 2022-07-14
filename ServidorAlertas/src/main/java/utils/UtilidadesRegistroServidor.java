package utils;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UtilidadesRegistroServidor {
    public static void initNs(int numPuertoRMIRegistry) throws RemoteException {

        try
        {
            Registry registro = LocateRegistry.getRegistry(numPuertoRMIRegistry);
            String[] vector=registro.list();
            for (String idNS : vector) {
                System.out.println("ns : "+idNS );
            }
            System.out.println("El rmiRegistry se ha obtenido y se encuentra escuchando en el puerto: " + numPuertoRMIRegistry);
        }
        catch(RemoteException e)
        {
            Registry registro = LocateRegistry.createRegistry(numPuertoRMIRegistry);
            System.out.println("Ns creado en el puerto[" + numPuertoRMIRegistry + "]");
        }

    }

    public static void RegistrarObjetoRemoto(Remote objRemoto, String direccionIp, int puertoRmiRegistry, String identificadorObjetoRemoto) {
        String UrlRegistro = "rmi://"+direccionIp+":"+puertoRmiRegistry+"/"+identificadorObjetoRemoto;
        try
        {
            Naming.rebind(UrlRegistro, objRemoto);
            System.out.println("Objeto remoto ["+identificadorObjetoRemoto+"]: "+"Registrado");
        } catch (RemoteException e)
        {
            System.out.println("Objeto remoto ["+identificadorObjetoRemoto+"]: "+"No Registrado");
            e.printStackTrace();
        } catch (MalformedURLException e)
        {
            System.out.println("Error url inválida");
            e.printStackTrace();
        }

    }
}

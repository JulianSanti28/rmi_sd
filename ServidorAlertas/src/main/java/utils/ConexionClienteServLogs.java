/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import lombok.Data;
import model.InformacionDTO;
import model.sensores.Sensor;
/**
 *
 * @author Paula
 */
@Data
public class ConexionClienteServLogs {
    private String dirIpServidor = "";
    private int puertoServidor;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private Socket socket;
    private InformacionDTO message;
    
    public void ServerConnection(String dirIP, int puerto){
        try {
            setDirIpServidor(dirIP);
            setPuertoServidor(puerto);
            setSocket(new Socket(dirIP, puerto));
            setFlujoEntrada(new DataInputStream(getSocket().getInputStream()));
            setFlujoSalida(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException excep) {
            excep.printStackTrace();
        }
    }
    
    public InformacionDTO peticion_respuesta(Sensor s){
        String tmp = null;
        try {
            
            flujoSalida.writeUTF(s.getNombre());
            tmp = flujoEntrada.readUTF();// operacion bloqueante
            //System.out.println("Pasa operacion bloqueante");
            message = GestionJSON.JsonToObject(tmp);
            getSocket().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return getMessage();
    }
}

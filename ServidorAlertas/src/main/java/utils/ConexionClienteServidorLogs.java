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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.InformacionDTO;

/**
 *
 * @author Paula
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConexionClienteServidorLogs {
    private String dirIpServidor = "";
    private int puertoServidor;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private Socket socket;
    private InformacionDTO message;
    
    public void ServerConnection( ){
        try {
            dirIpServidor="localhost";
            puertoServidor=2024;
            setSocket(new Socket(dirIpServidor, puertoServidor));
            setFlujoEntrada(new DataInputStream(getSocket().getInputStream()));
            setFlujoSalida(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException excep) {
            excep.printStackTrace();
        }
    }
    
    public InformacionDTO peticion_respuesta(){
        String tmp = null;
        try {
            //flujoSalida.writeUTF("caracteristicas");
            tmp = flujoEntrada.readUTF();// operacion bloqueante
            message = GestionJSON.JsonToObject(tmp);
            //getSocket().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return getMessage();
    }
    public void cerrarConexionConLogs() throws IOException{
        getSocket().close();
    }
}

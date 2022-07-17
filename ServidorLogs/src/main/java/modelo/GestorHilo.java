/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import servicios.InformacionSensor;

/**
 *
 * @author Paula
 */
public class GestorHilo extends Thread {
    private Socket objSocketCliente;
       
    public GestorHilo(Socket objSocket){
        this.objSocketCliente = objSocket;
    }
    
    @Override
    public void run() {
        try {
            //System.out.println("id del hilo generado:"+Thread.currentThread().getId());
            //System.out.println("Atendiendo hilo de cliente");
            DataInputStream flujoEntrada;
            DataOutputStream flujoSalida;
            String message;            
            flujoEntrada=new DataInputStream(objSocketCliente.getInputStream());
            flujoSalida=new DataOutputStream(objSocketCliente.getOutputStream());
            
            message = flujoEntrada.readUTF();//se bloquea el servidor

            message = InformacionSensor.atenderPeticion(message);
            //flujoSalida.writeUTF("Se ha registrado error en el servidor de losgs.. ");
            flujoSalida.writeUTF(message);
            System.out.println("Guardando excepcion.."+message);
               
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void cerrarsocket() throws IOException{
        objSocketCliente.close();

    }
}

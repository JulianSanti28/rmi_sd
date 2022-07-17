/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Paula
 */
public abstract class PlantillaServidor {
    private int PUERTO;
    protected ServerSocket objservidor;
    protected Socket objsocket;
 
    public abstract void atenderPeticiones();
    
    public void ejecutarServidor(){
        atenderPeticiones();
    }
    
    public boolean inicializarServidor(int prmPuerto){
        try {
            this.PUERTO=prmPuerto;
            objservidor = new ServerSocket(PUERTO);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

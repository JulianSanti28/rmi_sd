/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Paula
 */
public class ServidorConcurrente extends PlantillaServidor {

    public ServidorConcurrente() {} 
    
    @Override
    public void atenderPeticiones() {
        try {            
            while (true) {
                //System.out.println("id del hilo principal:"+Thread.currentThread().getId());
                this.objsocket=objservidor.accept();
                //System.out.println("Cliente conectado");
                new GestorHilo(this.objsocket).start();
            }
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }
    
}

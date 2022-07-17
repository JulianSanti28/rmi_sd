/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import modelo.PlantillaServidor;
import modelo.ServidorConcurrente;

/**
 *
 * @author Paula
 */
public class ServidorLogsMain {
    public static void main(String[] args) {
        try  {
            String tipo="";
            int puerto=2024;
            System.out.println("Iniciando servidor de Logs..");
            PlantillaServidor objServidor = new ServidorConcurrente();
            objServidor.inicializarServidor(puerto);
            objServidor.ejecutarServidor();
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

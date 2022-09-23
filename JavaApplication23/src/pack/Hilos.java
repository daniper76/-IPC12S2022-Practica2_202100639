/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Hilos implements Runnable{
    
    Culebra objeto1;
    Culebra objeto2;
    
    boolean momento=true;
    
    public Hilos(Culebra objeto1){
        this.objeto1=objeto1;
        
    }
    
    @Override
    public void run(){
        while(momento){
        objeto1.avanzar();
        objeto1.repaint();
        try {
            
            Thread.sleep(objeto2.velocidad);
            Ventana.etiquetavelocidad.setText(Integer.toString(objeto2.velocidad));
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    public void parar(boolean momento){
        this.momento=momento;
    }
}

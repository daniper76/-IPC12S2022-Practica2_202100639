/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

import javax.swing.JLabel;

/**
 *
 * @author danie
 */
public class Reloj extends Thread{
    
    JLabel etiquetaHilo;
    public Reloj(JLabel contadorTiempo){
        this.etiquetaHilo=contadorTiempo;
    }
    @Override
    public void run(){
        
        try{
            int x=0;
            while(Ventana.correrHilo==true){
                Thread.sleep(1000);
                iniciarHiloReloj(x);
                x++;
            }
        }catch (Exception e){
            System.out.println("Excepcion en el hilo del reloj"+e.getMessage());
        }
    }
    
    private void iniciarHiloReloj(int x){
        
        Ventana.segundos++;
        
        if(Ventana.segundos>59){
            Ventana.segundos=0;
            Ventana.minutos++;
            if(Ventana.minutos>59){
                Ventana.minutos=0;
                Ventana.hora++;
            }
        }
        
        String textosegundos="",textominutos="",textohoras="";
        
        if(Ventana.segundos<10){
            textosegundos="0"+Ventana.segundos;
        }
        else{
            textosegundos=""+Ventana.segundos;
        }
        
        if(Ventana.minutos<10){
            textominutos="0"+Ventana.minutos;
        }
        else{
            textominutos=""+Ventana.minutos;
        }
        
        if(Ventana.hora<10){
            textohoras="0"+Ventana.hora;
        }else{
            textohoras=""+Ventana.hora;
        }
        
        String reloj=textohoras+":"+textominutos+":"+textosegundos;
        etiquetaHilo.setText(reloj);
        
    }
    
}

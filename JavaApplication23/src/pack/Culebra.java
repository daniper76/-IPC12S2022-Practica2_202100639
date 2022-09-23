/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author danie
 */
public class Culebra  extends JPanel{
    
    Color BackCulebra= Color.red;
    Color ComidaCulebra=Color.blue;
    int tamanoMaximo,tamanoCuadros,cantidadCuadros;
    List<int[]>culebra=new ArrayList<>();
    int[]comida=new int[2];
    String direccion=null;
    String siguienteDireccion="derecha";
    static int velocidad=1000;
    Ventana objeto69;
    int contador=1;
    int contadorMovimientos=0;
    Thread hilo;
    Hilos recorrido;
    boolean terminar=false;
    
    public Culebra (int tamanoMaximo, int cantidadCuadros){
        this.tamanoMaximo=tamanoMaximo;
        this.cantidadCuadros=cantidadCuadros;
        this.tamanoCuadros=tamanoMaximo/cantidadCuadros;  
        int[]a={5,5};
        
        culebra.add(a);
        
        generarComida();
        int c=(int)(Math.random()*cantidadCuadros-1);
        int d=(int)(Math.random()*cantidadCuadros-1);   
        
        if(c==0){
                c=1;
            }
            if(c==12){
                c=11;
            }
            if(d==0){
                d=1;
            }
            if(d==12){
                d=11;
            }
            
        comida[0]=c;
        comida[1]=d;
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(BackCulebra);
        
        //for(int i=0;i<culebra.size();i++){
          // g.fillRect(culebra.get(i)[0]*tamanoCuadros,culebra.get(i)[1]*tamanoCuadros,tamanoCuadros-1,tamanoCuadros-1);
            //}
        
        for(int[] par:culebra){
            g.fillRect(par[0]*tamanoCuadros,par[1]*tamanoCuadros,tamanoCuadros-1,tamanoCuadros-1);
        }
        
        g.setColor(ComidaCulebra);
        g.fillRect(comida[0]*tamanoCuadros,comida[1]*tamanoCuadros,tamanoCuadros-1,tamanoCuadros-1);
        
        if(terminar){
            g.setColor(Color.yellow);
            for(int[] par:culebra){
            g.fillRect(par[0]*tamanoCuadros,par[1]*tamanoCuadros,tamanoCuadros-1,tamanoCuadros-1);
            }
            g.fillRect(comida[0]*tamanoCuadros,comida[1]*tamanoCuadros,tamanoCuadros-1,tamanoCuadros-1);
        
        
        }
    }
    
    public void avanzar(){
        int[] ultimo=culebra.get(culebra.size()-1);
        int agregarx=0;
        int agregary=0;
        
        
        igualarDireccion();
        
        switch(direccion){
            
            case "derecha":
                agregarx=1;
                contadorMovimientos=contadorMovimientos+1;
                Ventana.etiquetaMovimientos.setText(Integer.toString(contadorMovimientos));
                break;
            case "izquierda":
                agregarx=-1;
                contadorMovimientos=contadorMovimientos+1;
                Ventana.etiquetaMovimientos.setText(Integer.toString(contadorMovimientos));
                break;
            case "arriba":
                agregary=-1;
                contadorMovimientos=contadorMovimientos+1;
                Ventana.etiquetaMovimientos.setText(Integer.toString(contadorMovimientos));
                break;
            case "abajo":
                agregary=1;
                contadorMovimientos=contadorMovimientos+1;
                Ventana.etiquetaMovimientos.setText(Integer.toString(contadorMovimientos));
                break;          
        }
        int[] nuevo={Math.floorMod(ultimo[0]+agregarx,cantidadCuadros),Math.floorMod(ultimo[1]+agregary,cantidadCuadros)};
        
        
        
        boolean existe=false;
        
        for(int i=0;i<12;i++){
           if((nuevo[0]==0 &&nuevo[1]==i)||(nuevo[0]==11 && nuevo[0]==i)||(nuevo[0]==i && nuevo[1]==0)||(nuevo[0]==i&& nuevo[1]==11)){
                existe=true;               
                //break;
            }
        }
        if(existe){
            JOptionPane.showMessageDialog(this,"La serpiete ha topado con un muro y ha perecido, GAME OVER");
            Ventana.correrHilo=false;
            Ventana.hiloCorriendo=false;
            terminar=true;
            recorrido.parar(false);
            
            
            
        }
        else{
            if(nuevo[0]==comida[0]&&nuevo[1]==comida[1]){
                culebra.add(nuevo);
                generarComida();
                contador=contador+1;
                Ventana.etiqueta.setText(Integer.toString(contador));
                if(contador==25){
                    JOptionPane.showMessageDialog(this,"Haz ganado el juego, bien ahí :3","Victoria",JOptionPane.INFORMATION_MESSAGE);
                    Ventana.correrHilo=false;
                    Ventana.hiloCorriendo=false;
                    recorrido.parar(false);
                    
                }
                
                switch(objeto69.velocidad1){
                    case 1:
                        velocidad=(int) (velocidad*(1-0.03));
                        
                        break;
                    
                    case 2:
                        velocidad=(int) (velocidad*(1-0.06));
                        
                        
                        break;
                    
                    case 3:
                        velocidad=(int) (velocidad*(1-0.09));
                       
                        
                        break;
                }
            }
            else{
                culebra.add(nuevo);
                culebra.remove(0);
            }
        }
       
        
    }
    
    public void generarComida(){
        boolean existe=false;
        int a=(int)(Math.random()*cantidadCuadros-1);
        int b=(int)(Math.random()*cantidadCuadros-1);
        for (int[] par:culebra){
            if(a==0){
                a=1;
            }
            if(a==12){
                a=11;
            }
            if(b==0){
                b=1;
            }
            if(b==12){
                b=11;
            }
            
            if(par[0]==a && par[1]==b){
                existe=true;
                generarComida();
                break;
            }
        }
        if(!existe){
            if(a==0){
                a=1;
            }
            
            if(a==12){
                a=11;
            }
            
            if(b==0){
                b=1;
            }
            if(b==12){
                b=11;
            }
            this.comida[0]=a;
            this.comida[1]=b;
        }
    }
    
    public void cambiarDireccion(String dir){
        this.siguienteDireccion=dir;
    }
    public void igualarDireccion(){
        this.direccion=siguienteDireccion;
    }
   


}
            
    
     

    


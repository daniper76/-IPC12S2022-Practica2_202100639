/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author danie
 */
public class Panel extends JPanel{
    
    Color BackColor= Color.yellow;
    int tamanoMaximo,tamanoCuadros,cantidadCuadros;
    
    public Panel(int tamanoMaximo, int cantidadCuadros){
        this.tamanoMaximo=tamanoMaximo;
        this.cantidadCuadros=cantidadCuadros;
        this.tamanoCuadros=tamanoMaximo/cantidadCuadros;  
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(BackColor);
        for(int i=1;i<cantidadCuadros-1;i++){
            for(int j=1;j<cantidadCuadros-1;j++){
                g.fillRect(i*tamanoCuadros,j*tamanoCuadros,tamanoCuadros-1,tamanoCuadros-1);
            }
        }
            
    
    }
}

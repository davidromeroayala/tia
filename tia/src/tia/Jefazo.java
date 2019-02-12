/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tia;

/**
 *
 * @author alumno
 */
public class Jefazo  extends Agente{
    private int añosMandato;

   
    
    public Jefazo(int añosMandato, String nombre, String edad, String direccion, String salario) {
        super(nombre, edad, direccion, salario);
        this.añosMandato = 0;
    }

    @Override
    public String toString() {
         
      return "********************\n"+super.toString()+"\nAños Mandato "+añosMandato+"\n********************";
        
    }
    
    
    
}

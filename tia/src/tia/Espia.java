/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tia;

import ioDatos.Fichero;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Espia extends Agente{
    private ArrayList <String> vPiso;

    public Espia( String nombre, String edad, String direccion, String salario) {
        super(nombre, edad, direccion, salario);
        this.vPiso = Fichero.leerPiso();
    }

    @Override
    public String toString() {
         String pisos="";
        for (String pi : vPiso) {
            pisos+=pi + " ";
        }
        return super.toString() + "\nPisos " + pisos ;
    }
    
    
}

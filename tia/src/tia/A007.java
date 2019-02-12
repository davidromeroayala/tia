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
public class A007 extends Agente {
    private int muertes;
    private ArrayList <String> vArmas;

    public A007(int muertes,  String nombre, String edad, String direccion, String salario) {
        super(nombre, edad, direccion, salario);
        this.muertes = muertes;
        this.vArmas = Fichero.leerArma();
    }

    @Override
    public String toString() {
        String armas="";
        for (String vArma : vArmas) {
            armas+=vArma + " ";
        }
        
        return super.toString() + "muertes=" + muertes + ", vArmas=" + armas ;
    }

    
    
}

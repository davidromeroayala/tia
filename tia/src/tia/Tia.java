/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tia;

import ioDatos.Fichero;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import menu.Menu;

/**
 *
 * @author alumno
 */
public class Tia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int opc=0;
         ArrayList<Agente> vAgentes=null;
         ArrayList<String> vArmas=null;
         ArrayList<String> vPisos=null;
        File fichero = new File ("recursos/cifrado.dat");
        //inicializamos con los datos adecuados
        if (fichero.exists()) {
            Fichero.desencriptar();
            vAgentes= Fichero.leerAgente();
            vArmas= Fichero.leerArma();
            vPisos= Fichero.leerPiso(); 
        }else{
             vAgentes = Fichero.leerAgente();
             vArmas = Fichero.leerArma();
             vPisos = Fichero.leerPiso();
        }
        
   
        try{
            while (opc!=8&&opc>=0&&opc<=8) {            
            Menu.menu();
            leer=new Scanner(System.in);
            opc=leer.nextInt(); 
            switch(opc){
                case 1:
                        for (Agente a : vAgentes) {
                            System.out.println(a); 
                            System.out.println("");
                        }
                    break;
                case 2:
                    System.out.println("introduzca el salario minimo");
                    int salario=leer.nextInt();
                    for (Agente a : vAgentes) {
                        if (a.getSalario()>salario) {
                            System.out.println(a); 
                            System.out.println("");
                        }
                    }
                    break;
                case 3: 
                    System.out.println("Introduzca la direccion del piso");
                    vPisos.add(leer.next());
                    break;
                case 4:
                    System.out.println("Introduzca la nueva arma");
                    vPisos.add(leer.next());
                    break;
                case 5:
                    Menu.nuevoAgente();
                    leer=new Scanner(System.in);
                    opc=leer.nextInt(); 
                    switch(opc){
                        
                        case 1:
                            System.out.println("introduzca en el siguiente orden los datos: años de mandato, nombre, edad, direccion, salario");
                            Jefazo j=new Jefazo(leer.nextInt(), leer.next(), leer.next(), leer.next(), leer.next());
                            vAgentes.add(j);
                            break;
                        case 2:
                            System.out.println("introduzca en el siguiente orden los datos:Nº de muertes , nombre, edad, direccion, salario");
                            A007 a=new A007(leer.nextInt(), leer.next(), leer.next(), leer.next(), leer.next());
                            vAgentes.add(a);
                            break;
                        case 3: 
                            System.out.println("introduzca en el siguiente orden los datos: nombre, edad, direccion, salario");
                            Espia e=new Espia(leer.next(), leer.next(), leer.next(), leer.next());
                            vAgentes.add(e);
                            break;
                    }
                    break;
                case 6:
                    Fichero.encriptar(vAgentes,vPisos, vArmas);
                    vAgentes=null;
                    vArmas=null;
                    vPisos=null;
                    break;
                case 7:
                    
                    Fichero.desencriptar();
                    vAgentes= Fichero.leerAgente();
                    vArmas= Fichero.leerArma();
                    vPisos= Fichero.leerPiso(); 
                    break;
                case 8:
                    System.out.println("Adios");
                    Fichero.escribirAgente(vAgentes);
                    Fichero.escribirArmas(vArmas);
                    Fichero.escribirPisos(vPisos);
                    break;
               
            }
        
            }
      
        
        }catch(Exception e){
            System.out.println("Fallo");
        }
    
    }

}

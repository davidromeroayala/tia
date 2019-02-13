/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA_2_3.portable.OutputStream;
import tia.Agente;

/**
 *
 * @author alumno
 */
public class Fichero {
      public static void escribirArmas(ArrayList<String> vArmas){
     
        File f=new File("recursos/armas.txt");
        FileOutputStream fo=null;
        ObjectOutputStream escribir=null;

        if(!f.exists()){
              try {
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
            fo = new FileOutputStream(f,true);
            escribir = new ObjectOutputStream(fo);
            for (String  c : vArmas) {
                 escribir.writeObject(c);
            }
           
        } catch (IOException ex) {
            System.out.println("No se puede escribir en el fichero");
        }finally{
            if (escribir!=null)
                try {
                    escribir.close();
            } catch (IOException ex) {
                    System.out.println("Fallo ");
            }
        }
      
    }
    public static void escribirPisos(ArrayList<String> vPiso){
     
        File f=new File("recursos/pisos.txt");
        FileOutputStream fo=null;
        ObjectOutputStream escribir=null;

        if(!f.exists()){
              try {
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
            fo = new FileOutputStream(f,true);
            escribir = new ObjectOutputStream(fo);
            for (String  c : vPiso) {
                 escribir.writeObject(c);
            }
           
        } catch (IOException ex) {
            System.out.println("No se puede escribir en el fichero");
        }finally{
            if (escribir!=null)
                try {
                    escribir.close();
            } catch (IOException ex) {
                    System.out.println("Fallo ");
            }
        }      
    }
     public static void escribirAgente(ArrayList<Agente> vAgente){
     
        File f=new File("recursos/armas.txt");
        FileOutputStream fo=null;
        ObjectOutputStream escribir=null;

        if(!f.exists()){
              try {
                   f.getParentFile().mkdirs();
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
            fo = new FileOutputStream(f,true);
            escribir = new ObjectOutputStream(fo);
            for (Agente  c : vAgente) {
                 escribir.writeObject(c);
            }
           
        } catch (IOException ex) {
            System.out.println("No se puede escribir en el fichero");
        }finally{
            if (escribir!=null)
                try {
                    escribir.close();
            } catch (IOException ex) {
                    System.out.println("Fallo ");
            }
        }
    }
     
     //Lectura de un fichero de texto y devulve el ArrayList de armas
 public static ArrayList<String> leerArma(){
        ArrayList<String> vArmas=new ArrayList();
        File f=new File("recursos/armas.txt");
        Scanner leer = null;
    
        if(!f.exists()){
              try {
                  f.getParentFile().mkdirs();
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
           leer = new Scanner(f);
           while(leer.hasNext()){
               vArmas.add(leer.nextLine());
           }
           
          // vContacto = (ArrayList<Contacto>) leer.readObject();
        } catch (IOException ex) {
            //System.out.println("Lectura terminada");
        
        }finally{
            if (leer!=null)
                leer.close();
        }
      
        return vArmas;
    }     
 
 
  //Lectura de un fichero de texto y devulve el ArrayList de pisos
     public static ArrayList<String> leerPiso(){
        ArrayList<String> vArmas=new ArrayList();
        File f=new File("recursos/pisos.dat");
        Scanner leer = null;
    
        if(!f.exists()){
              try {
                  f.getParentFile().mkdirs();
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
           leer = new Scanner(f);
           while(leer.hasNext()){
               vArmas.add(leer.nextLine());
           }
           
          // vContacto = (ArrayList<Contacto>) leer.readObject();
        } catch (IOException ex) {
            //System.out.println("Lectura terminada");
        
        }finally{
            if (leer!=null)
                leer.close();
        }
      
        return vArmas;
    }     
    public static ArrayList<Agente> leerAgente(){
    ArrayList<Agente> vAgente=new ArrayList();
    File f=new File("recursos/agente.dat");
    FileInputStream fi = null;
    ObjectInputStream leer = null;
    
        if(!f.exists()){
              try {
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
           fi = new FileInputStream(f);
           leer = new ObjectInputStream(fi);
           while(true){
               vAgente.add((Agente)leer.readObject());
           }
           
          // vContacto = (ArrayList<Contacto>) leer.readObject();
        } catch (IOException ex) {
            //System.out.println("Lectura terminada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro al leer del fichero");
        }finally{
         try {
             if (leer!=null)
                leer.close();
         } catch (IOException ex) {
             
         }
        }
      
        return vAgente;
    }     
    public static void encriptar(ArrayList<Agente> vAgente,ArrayList<String> vPiso,ArrayList<String> vArma){
     
        File f = new File ("recursos/cifrado.dat");
        
        FileOutputStream fo=null;
        ObjectOutputStream escribir=null;

        File[] files = f.getParentFile().listFiles();
        for (int i=0; i<files.length;i++){
            files[i].delete();
        }
        
        
        if(!f.exists()){
              try {
                   f.getParentFile().mkdirs();
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
            fo = new FileOutputStream(f,true);
            escribir = new ObjectOutputStream(fo);
            escribir.writeObject(vAgente);
            escribir.writeObject(vArma);
            escribir.writeObject(vPiso);
           
        } catch (IOException ex) {
            System.out.println("No se puede escribir en el fichero");
        }finally{
            if (escribir!=null)
                try {
                    escribir.close();
            } catch (IOException ex) {
                    System.out.println("Fallo ");
            }
        }
    }
     public static void desencriptar(){
     
        
        
        
        File f = new File ("recursos/cifrado.dat");
        
        FileInputStream fo;
        ObjectInputStream leer=null;
          
        

        if(!f.exists()){
              try {
                   f.getParentFile().mkdirs();
                  f.createNewFile();
              } catch (IOException ex) {
                  System.out.println("Fallo al comprobar el archivo");
              }
        }
        try {
           fo = new FileInputStream(f);
           leer=new ObjectInputStream(fo);
          
            escribirAgente((ArrayList<Agente>)leer.readObject());
           escribirArmas((ArrayList<String>)leer.readObject());
           escribirPisos((ArrayList<String>)leer.readObject());
          
           
           
        } catch (IOException ex) {
            System.out.println("No se puede leer en el fichero");
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (leer!=null)
                try {
                    leer.close();
            } catch (IOException ex) {
                    System.out.println("Fallo ");
            }
        }
        
       
    }
}
 


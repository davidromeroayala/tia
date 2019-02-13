/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tia;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author alumno
 */
public class Agente implements Serializable{
    protected String nombre;
    protected String  edad;
    protected String direccion;
    protected String salario;

    public Agente(String nombre, String edad, String direccion, String salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + "\nEdad=" + edad + "\nDireccion=" + direccion + "\nSalario=" + salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSalario() {
       int salarios = Integer.parseInt(salario);
        return salarios;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    


   
}

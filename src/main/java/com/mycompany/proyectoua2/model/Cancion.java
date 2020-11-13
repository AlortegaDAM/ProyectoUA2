/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.io.Serializable;

/**
 *
 * @author Vinil
 */
public class Cancion implements Serializable{
    public int id;
    public String nombre;  
    public int duracion;
    public Disco disco;
    public int id_disco;
    
    public Cancion() {
        this.id=-1;
        this.nombre="";
        this.id_disco=-1;
        
    }

    public Cancion(String nombre, int duracion, int id_disco) {
        this.id = -1;
        this.nombre = nombre;
        this.duracion = duracion;
        this.id_disco = id_disco;
    }
    

    public Cancion(String nombre, int id, int duracion, Disco disco) {
        this.id = id;
        this.nombre = nombre;
        
        this.duracion = duracion;
        this.disco = disco;
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the disco
     */
    public Disco getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(Disco disco) {
        this.disco = disco;
    }


    

    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }
    
    @Override
    public String toString(){
        return("Nombre: " + this.getNombre()+", duracion: " + this.getDuracion()+", id: ");
    }
}

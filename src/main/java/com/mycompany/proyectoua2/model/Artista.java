/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Vinil
 */
public class Artista implements Serializable{
   public int id;
    public String nombre;
    public String nacionalidad;
    public String foto;
    private ArrayList<Disco> discos;

    public int getId() {
        return id;
    }

    public Artista() {
        this.id=-1;
        this.nombre="";
        this.nacionalidad="";
        this.foto="";
        
    }
    public Artista(String nombre, String nacionalidad, String foto) {
        this.id = -1;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
       
    }

    public Artista(int id, String nombre, String nacionalidad, String foto, ArrayList<Disco> discos) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
        this.discos = discos;
    }
     public Artista(int id) {
        this.id = id;
       
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", foto=" + foto + '}';
    }
    
    
}


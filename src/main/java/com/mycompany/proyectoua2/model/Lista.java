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
 * @author adryc
 */
public class Lista implements Serializable {
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected Usuario creador;
    protected int id_usuario;
    protected ArrayList<Cancion> canciones;

    public Lista(){
        this.id=-1;
        this.nombre="";
        this.descripcion="";
        this.id_usuario=-1;
    }

    public Lista( String nombre, String descripcion, int id_usuario) {
        this.id = -1;
        this.nombre = nombre;
        this.descripcion = descripcion;       
        this.id_usuario = id_usuario;
    }

    
    
    public Lista(int id, String nombre, String descripcion, Usuario creador, ArrayList<Cancion> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creador = creador;
        this.canciones = canciones;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the creador
     */
    public Usuario getCreador() {
        return creador;
    }

    /**
     * @param creador the creador to set
     */
    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    /**
     * @return the canciones
     */
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    
}

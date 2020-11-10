/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Disco implements Serializable{
    private int id;
    private String nombre;
    private String foto;
    private Artista artista;
    private Date fecha;
    private ArrayList<Cancion> canciones;

    public Disco() {
    }

    public Disco(int id, String nombre, String foto, Artista artista, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.artista = artista;
        this.fecha = fecha;
        this.canciones = new ArrayList<>();
    }
    
    

    public int getId() {
        return id;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Disco{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + '}';
    }

    /**
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Disco implements Serializable {

    protected int id;
    protected String nombre;
    protected String foto;
    protected Artista artista;
    protected int id_artista;
    protected LocalDate fecha_produccion;
    protected ArrayList<Cancion> canciones;

    public int getId() {
        return id;
    }

    public Disco(String nombre, String foto, LocalDate fecha_produccion, int id_artista) {
        this.id = -1;
        this.nombre = nombre;
        this.foto = foto;
        this.id_artista = id_artista;
        ;

    }

    public Disco() {
        this.id=-1;
        this.nombre="";
        this.fecha_produccion = LocalDate.now();
        this.foto="";
        this.id_artista=-1;
    }
    

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public LocalDate getFecha_produccion() {
        return fecha_produccion;
    }

    public void setFecha_produccion(LocalDate fecha_produccion) {
        this.fecha_produccion = fecha_produccion;
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
        return "Disco{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + "}";
    }

    /**
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
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

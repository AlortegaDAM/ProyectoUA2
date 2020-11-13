/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Vinil
 */
public interface IDisk {
    public int getId_artista();

    public void setId_artista(int id_artista) ;

    public LocalDate getFecha_produccion() ;

    public void setFecha_produccion(LocalDate fecha_produccion) ;
    

    public void setId(int id) ;

    public String getNombre() ;

    public void setNombre(String nombre) ;

    public String getFoto() ;

    public void setFoto(String foto);

    @Override
    public String toString() ;
    /**
     * @return the artista
     */
    public Artista getArtista() ;
    /**
     * @param artista the artista to set
     */
    public void setArtista(Artista artista) ;
    /**
     * @return the canciones
     */
    public ArrayList<Cancion> getCanciones();

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(ArrayList<Cancion> canciones);
    
}

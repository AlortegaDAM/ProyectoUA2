/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.util.ArrayList;

/**
 *
 * @author Vinil
 */
public interface IList {
    
    
    /**
     * @return the id
     */
    public int getId();

    public int getId_usuario();

    public void setId_usuario(int id_usuario);
    

    /**
     * @param id the id to set
     */
    public void setId(int id);

    /**
     * @return the nombre
     */
    public String getNombre();

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre);

    /**
     * @return the descripcion
     */
    public String getDescripcion();

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion);

    /**
     * @return the creador
     */
    public Usuario getCreador();

    /**
     * @param creador the creador to set
     */
    public void setCreador(Usuario creador);
    /**
     * @return the canciones
     */
    public ArrayList<Cancion> getCanciones();

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(ArrayList<Cancion> canciones);
    
    @Override
    public String toString();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

/**
 *
 * @author Vinil
 */
public interface ISong {
    
    public String getNombre() ;
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre);
    /**
     * @return the id
     */
    public int getId();

    /**
     * @param id the id to set
     */
    public void setId(int id) ;
    /**
     * @return the duracion
     */
    public int getDuracion() ;
    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion);
    /**
     * @return the disco
     */
    public Disco getDisco();
    /**
     * @param disco the disco to set
     */
    public void setDisco(Disco disco) ;
    public int getId_disco() ;

    public void setId_disco(int id_disco) ;
    
    @Override
    public String toString();
    
}

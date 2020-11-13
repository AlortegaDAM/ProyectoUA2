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
public interface IUser {
    
    
    public int getId();

    /**
     * @param id the id to set
     */
    public void setId(int id);
    /**
     * @return the correo
     */
    public String getCorreo();

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo);
    /**
     * @return the nombre
     */
    public String getNombre();
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre);
    public String getFoto();
    public void setFoto(String foto);

    @Override
    public String toString();
    
}

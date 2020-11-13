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
public interface IArtist {
    
    public int getId();
    public void setId(int id);
    public String getNombre();
    public void setNombre(String nombre);
    public String getNacionalidad();
    public void setNacionalidad(String nacionalidad);
    public String getFoto();
    public void setFoto(String foto);
    @Override
    public String toString();
     
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.sql.Timestamp;

/**
 *
 * @author Vinil
 */
public interface IComment {
    
    public String getMensaje() ;
    public void setMensaje(String mensaje) ;
    public int getID_Usuario() ;
    public void setID_Usuario(int ID_Usuario) ;

    public int getID_Lista() ;

    public void setID_Lista(int ID_Lista) ;
    /**
     * @return the id
     */
    public int getId() ;
    /**
     * @param id the id to set
     */
    public void setId(int id) ;
    /**
     * @return the autor
     */
    public Usuario getAutor() ;
    /**
     * @param autor the autor to set
     */
    public void setAutor(Usuario autor) ;
    /**
     * @return the lista
     */
    public Lista getLista() ;
    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) ;
    /**
     * @return the momento
     */
    public Timestamp getMomento() ;
    /**
     * @param momento the momento to set
     */
    public void setMomento(Timestamp momento);
    
}

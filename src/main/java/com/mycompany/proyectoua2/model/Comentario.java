/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author adryc
 */
public class Comentario implements Serializable{
    public int id;
    public Usuario autor;
    public String mensaje;
    public Lista lista;
    public Timestamp momento;
    public int ID_Usuario;
    public int ID_Lista;

    public Comentario() {
    }

    public Comentario(int id, Usuario autor, Lista lista, Timestamp momento) {
        this.id = id;
        this.autor = autor;
        this.lista = lista;
        this.momento = momento;
    }

    public Comentario(int id, String mensaje, int ID_Usuario, int ID_Lista) {
        this.id = id;
        this.mensaje=mensaje;
        this.ID_Usuario = ID_Usuario;
        this.ID_Lista = ID_Lista;
    }

    public Comentario(int id) {
        this.id = id;

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public int getID_Lista() {
        return ID_Lista;
    }

    public void setID_Lista(int ID_Lista) {
        this.ID_Lista = ID_Lista;
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the autor
     */
    public Usuario getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    /**
     * @return the lista
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    /**
     * @return the momento
     */
    public Timestamp getMomento() {
        return momento;
    }

    /**
     * @param momento the momento to set
     */
    public void setMomento(Timestamp momento) {
        this.momento = momento;
    }

}

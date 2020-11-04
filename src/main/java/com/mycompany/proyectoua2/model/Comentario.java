/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.sql.Timestamp;

/**
 *
 * @author adryc
 */
public class Comentario {
    private int id;
    private Usuario autor;
    private Lista lista;
    private Timestamp momento;

    public Comentario() {
    }

    public Comentario(int id, Usuario autor, Lista lista, Timestamp momento) {
        this.id = id;
        this.autor = autor;
        this.lista = lista;
        this.momento = momento;
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

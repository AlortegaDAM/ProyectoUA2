/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoua2.model;

import java.io.Serializable;

/**
 *
 * @author adryc
 */
public class Usuario implements Serializable {

    protected int id;
    protected String correo;
    protected String nombre;
    protected String foto;

    public Usuario() {
        this.id = -1;
        this.correo = "";
        this.nombre = "";
        this.foto = "";

    }

    public Usuario(String correo, String nombre, String foto) {
        this.id = -1;
        this.correo = correo;
        this.nombre = nombre;
        this.foto = foto;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "ID: " + this.id+ ", Correo: " + this.correo + ", Nombre: " + this.nombre;
    }

}

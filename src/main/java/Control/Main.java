/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.mycompany.proyectoua2.model.Artista;

/**
 *
 * @author adryc
 */
class Main{
    public static void main(String[] args) {
        Artista a = new Artista("Miguelito", "España", "Foto.png");
        Controlador control = new Controlador();
        control.crearArtista(a);
        System.out.println(control.mostrarArtistas());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.mycompany.proyectoua2.model.Artista;
import com.mycompany.proyectoua2.model.Cancion;
import com.mycompany.proyectoua2.model.Disco;

/**
 *
 * @author adryc
 */
class Main{
    public static void main(String[] args) {
        Artista a = new Artista("Adri", "Artantida", "Foto2.png");
        Cancion c = new Cancion("Si", 180, 200, null);
        Controlador control = new Controlador();
        control.crearArtista(a);
        control.crearCancion(c);
        System.out.println(control.mostrarArtistas());
        System.out.println(control.mostrarCanciones());
    }
}

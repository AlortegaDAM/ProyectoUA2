/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.UIUtilities;

/**
 *
 * @author Carlos
 */
public class listDiscoView {
    Controller.Controlador control=new Controller.Controlador();
    view.DiscosView v=new view.DiscosView();
    public  void listSong() {
        int opcion = 0;

        do {
            System.out.println("Listado de canciones");
            System.out.println("1)Listar todos los discos");
            System.out.println("2)Listar todos los discos por nombre");
            System.out.println("3)Listar todos los discos por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                control.mostrarDiscos();
                break;
            case 2:
               System.out.println("Introduce el nombre del disco que quieras buscar");
             String nombre=UIUtilities.getString();
                control.mostrarDiscosNombre(nombre);
                break;
            case 3:
                System.out.println("Introduce la ID del cancion que quieras buscar");
                int id=UIUtilities.getInt();
                control.buscarDiscoID(id);
                break;
            case 4:
                v.discos();
                break;
        }
    }
}

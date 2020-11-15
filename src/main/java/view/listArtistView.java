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
public class listArtistView {
        

    Controller.Controlador control=new Controller.Controlador();
    view.ArtistView v=new view.ArtistView();
    
    public  void listArtist() {
        int opcion = 0;

        do {
            System.out.println("Listado de Artistas");
            System.out.println("1)Listar todos los artistas");
            System.out.println("2)Listar todos los artistas por nombre");
            System.out.println("3)Listar todos los artistas por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                control.mostrarArtistas();
                break;
            case 2:
                System.out.println("Introduce el nombre del artista que quieras buscar");
                String nombre=UIUtilities.getString();
                control.buscarArtistaNombre(nombre);
                break;
            case 3:
                System.out.println("Introduce la ID del artista que quieras buscar");
                int id=UIUtilities.getInt();
                control.buscarArtistaID(opcion);
                break;
            case 4:
                v.artistas();
                break;
        }
    }
}

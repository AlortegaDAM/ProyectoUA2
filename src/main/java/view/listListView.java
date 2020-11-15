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
public class listListView {
    
     Controller.Controlador control=new Controller.Controlador();
    view.ListasView v=new view.ListasView();
    
    public  void listUser() {
        int opcion = 0;

        do {
            System.out.println("Listado de usuarios");
            System.out.println("1)Listar todos los listas");
            System.out.println("2)Listar todos los listas por nombre");
            System.out.println("3)Listar todos los listas por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                control.mostrarListas();
                break;
            case 2:
                System.out.println("Introduce el nombre de la lista que quieras buscar");
                String nombre=UIUtilities.getString();
                control.mostrarListasNombre(nombre);
                break;
            case 3:
                System.out.println("Introduce la ID del usuarios que quieras buscar");
                int id=UIUtilities.getInt();
                control.buscarListaID(id);
                break;
            case 4:
                v.listasReproduccion();
                break;
        }
    }
}

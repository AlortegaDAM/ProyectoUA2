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
public class listUserView {
    
    Controller.Controlador control=new Controller.Controlador();
    view.UserView v=new view.UserView();
    
    public  void listUser() {
        int opcion = 0;

        do {
            System.out.println("Listado de usuarios");
            System.out.println("1)Listar todos los usuarios");
            System.out.println("2)Listar todos los usuarios por nombre");
            System.out.println("3)Listar todos los usuarios por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                control.mostrarUsuarios();
                break;
            case 2:
                System.out.println("Introduce el nombre del usuarios que quieras buscar");
                String nombre=UIUtilities.getString();
                control.mostrarUsuariosNombre(nombre);
                break;
            case 3:
                System.out.println("Introduce la ID del usuarios que quieras buscar");
                int id=UIUtilities.getInt();
                control.buscarUsuarioID(id);
                break;
            case 4:
                v.usuarios();
                break;
        }
    }
}

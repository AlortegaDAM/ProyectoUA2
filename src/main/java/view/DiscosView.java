/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.UIUtilities;
import com.mycompany.proyectoua2.model.Disco;

/**
 *
 * @author Vinil
 */
public class DiscosView {

    Controller.Controlador control = new Controller.Controlador();
    int id;

    public void discos() {
        int opciondisco;
        do {
            System.out.println("Bienvenido al menu Discos");
            System.out.println("Seleccione una opción:");
            System.out.println("----------------------------");
            System.out.println("1.- Nuevo Disco");
            System.out.println("2.- Editar Disco");
            System.out.println("3.- Eliminar Disco");
            System.out.println("4.- Listado de Discos");
            System.out.println("5.- Volver al menú principal");
            System.out.println("----------------------------");

            opciondisco = UIUtilities.getInt();

            switch (opciondisco) {

                case 1:
                    UIUtilities.clearScreen();
                    Disco a = new Disco();
                    System.out.println("Introduce el nombre");
                    String nombre = UIUtilities.getString();
                    a.setNombre(nombre);
                    System.out.println("Introduce la foto");
                    String foto = UIUtilities.getString();
                    a.setFoto(foto);
                    System.out.println("Introduce fecha de publicacion");
                    //Fecha de publicacion
                    //  a.setFecha_produccion(duracion);             
                    control.crearDisco(a);
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del disco que quieras editar");
                    id = UIUtilities.getInt();
                    control.actualizarDisco(id);
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del disco que quieras borrar");
                    id = UIUtilities.getInt();
                    control.borrarDisco(id);
                    break;

                case 4:
                    UIUtilities.clearScreen();
                    // listarDisco();
                    
                    break;

                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opciondisco != 5);
    }

}

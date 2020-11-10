
package view;

import Util.UIUtilities;
import static view.ArtistasView.artistas;
import static view.CancionesView.canciones;
import static view.DiscosView.discos;
import static view.ListasView.listasReproduccion;
import static view.UsuariosView.usuarios;

/**
 *
 * @author Vinil
 */
public class MainView {
    public static void mainView() {
        
        int opciones;
        do {
            UIUtilities.clearScreen();
            System.out.println("Bienvenido al Sistema de Música");
            System.out.println("¿Qué desea realizar?");
            System.out.println("---------------------------------");            
            System.out.println("1.- Gestión de Artistas");
            System.out.println("2.- Gestion de Canciones");
            System.out.println("3.- Gestion de Discos");
            System.out.println("4.- Gestion de Listas de Reproducción");
            System.out.println("5.- Gestion de Usuarios");
            System.out.println("6.- Salir del Sistema de Música");
            System.out.println("---------------------------------");

            opciones = UIUtilities.getInt();
            switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                    artistas();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    canciones();
                    break;
                case 3:
                    UIUtilities.clearScreen();
                    discos();
                    break;
                case 4:
                    UIUtilities.clearScreen();
                    listasReproduccion();
                    break;
                case 5:
                    UIUtilities.clearScreen();
                    usuarios();
                case 6:
                    System.out.println("Saliendo del sistema de Reparto");

                    break;
                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }

        } while (opciones != 6);
}
     
}


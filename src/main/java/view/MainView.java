
package view;

import Util.UIUtilities;


/**
 *
 * @author Vinil
 */
public class MainView {
    
    view.ArtistView a=new view.ArtistView();
    view.SongView c=new view.SongView();
    view.DiscosView d=new view.DiscosView();
    view.ListasView l=new view.ListasView();
    view.UserView u=new view.UserView();

    
    public void mainView() {
        
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
                    a.artistas();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    c.canciones();
                    break;
                case 3:
                    UIUtilities.clearScreen();
                    d.discos();
                    break;
                case 4:
                    UIUtilities.clearScreen();
                    l.listasReproduccion();
                    break;
                case 5:
                    UIUtilities.clearScreen();
                    u.usuarios();
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


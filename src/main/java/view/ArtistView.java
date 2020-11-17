package view;

import Util.UIUtilities;
import com.mycompany.proyectoua2.model.Artista;

/**
 *
 * @author Vinil
 */
public class ArtistView {

    Controller.Controlador control = new Controller.Controlador();
    view.listArtistView lav = new view.listArtistView();
    view.MainView main=new view.MainView();
    

    public static void artistas() {
        int id;
        int opcionartista;
        do {
            System.out.println("Bienvenido al menu Artistas");
            System.out.println("Seleccione una opción:");
            System.out.println("----------------------------");
            System.out.println("1.- Nuevo Artista");
            System.out.println("2.- Editar Artista");
            System.out.println("3.- Eliminar Artista");
            System.out.println("4.- Listado de Artistas");
            System.out.println("5.- Volver al menú principal");
            System.out.println("----------------------------");

            opcionartista = UIUtilities.getInt();

            switch (opcionartista) {

                case 1:
                    UIUtilities.clearScreen();

                    System.out.println("Introduce el nombre");
                    String nombre = UIUtilities.getString();
                    System.out.println("Introduce la nacionalidad");
                    String nacionalidad = UIUtilities.getString();
                    System.out.println("Introduce la URL de la foto");
                    String foto = UIUtilities.getString();
                    Artista a = new Artista(nombre, nacionalidad, foto);
                    //control.crearArtista(a);
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del artista  que quieras editar");
                    id = UIUtilities.getInt();
                    control.actualizarArtista(id);
                    break;

                 

                case 3:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del Artista que quieras borrar");
                    id = UIUtilities.getInt();
                    control.borrarArtista(id);
                    break;

                case 4:
                    UIUtilities.clearScreen();
                    lav.listArtist();
                    break;

                case 5:
                    main.mainView();
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opcionartista != 5);
    }

}

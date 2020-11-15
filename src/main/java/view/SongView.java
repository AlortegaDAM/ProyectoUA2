package view;

import Util.UIUtilities;
import static Util.UIUtilities.espera;
import com.mycompany.proyectoua2.model.Cancion;

/**
 *
 * @author Vinil
 */
public class SongView {

    Controller.Controlador control = new Controller.Controlador();
    int id;
    int duracion;

    public void canciones() {
        int opcioncancion;
        do {
            System.out.println("Bienvenido al menu Canciones");
            System.out.println("Seleccione una opción:");
            System.out.println("----------------------------");
            System.out.println("1.- Nueva Canción");
            System.out.println("2.- Editar Canción");
            System.out.println("3.- Eliminar Canción");
            System.out.println("4.- Listado de Canciones");
            System.out.println("5.- Volver al menú principal");
            System.out.println("----------------------------");

            opcioncancion = UIUtilities.getInt();

            switch (opcioncancion) {

                case 1:
                    UIUtilities.clearScreen();
                    Cancion a = new Cancion();
                    System.out.println("Introduce el nombre");
                    String nombre = UIUtilities.getString();
                    a.setNombre(nombre);
                    System.out.println("Introduce la foto");
                    duracion = UIUtilities.getInt();
                    a.setDuracion(duracion);
                    System.out.println("Introduce el ID del Disco");
                    id = UIUtilities.getInt();
                    a.setId_disco(duracion);
                    control.crearCancion(a);
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id de la cancion que quieras editar");
                    id = UIUtilities.getInt();
                    control.actualizarCancion(id);
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id de la cancion que quieras borrar");
                    int id = UIUtilities.getInt();
                    control.borrarArtista(id);
                    break;

                case 4:
                    UIUtilities.clearScreen();
                    // listarCancion();
                    espera();
                    break;

                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opcioncancion != 5);
    }

}

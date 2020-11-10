
package view;

import Util.UIUtilities;
import static Util.UIUtilities.espera;


/**
 *
 * @author Vinil
 */
public class CancionesView {
    
        public static void canciones() {
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
                   // nuevaCancion();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                   // editarCancion();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                   // borrarCancion();
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

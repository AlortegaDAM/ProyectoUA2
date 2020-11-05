
package view;

import utils.UIUtilities;
import static utils.UIUtilities.espera;





/**
 *
 * @author Vinil
 */
public class ListasView {
    
        public static void listasReproduccion() {
        int opcionlista;
        do {
            System.out.println("Bienvenido al menu Listas de Reproducción");
            System.out.println("Seleccione una opción:");
            System.out.println("----------------------------");
            System.out.println("1.- Nueva Lista de Reproducción");
            System.out.println("2.- Editar Lista de Reproducción");
            System.out.println("3.- Eliminar Lista de Reproducción");
            System.out.println("4.- Listado de Listas de Reproducción");
            System.out.println("5.- Volver al menú principal");
            System.out.println("----------------------------");
            
            opcionlista = UIUtilities.getInt();

            switch (opcionlista) {

                case 1:
                    UIUtilities.clearScreen();
                  //  nuevaLista();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                   // editarLista();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                   // borrarLista();
                    break;

                case 4:
                    UIUtilities.clearScreen();
                   // listarLista();
                    espera();
                    break;
        
                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opcionlista != 5);
    }
    
}

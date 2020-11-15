
package view;

import Util.UIUtilities;
import static Util.UIUtilities.espera;
import com.mycompany.proyectoua2.model.Lista;





/**
 *
 * @author Vinil
 */
public class ListasView {
    Control.Controlador control=new Control.Controlador();
        public  void listasReproduccion() {
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
                    Lista a = new Lista();
                    System.out.println("Introduce el nombre");
                    String nombre = UIUtilities.getString();
                    a.setNombre(nombre);
                    System.out.println("Introduce la descripcion");
                    String descripcion = UIUtilities.getString();
                    a.setDescripcion(descripcion);
                    
                 
                    control.crearLista(a);
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id de la lista que quieras editar");
                    int id = UIUtilities.getInt();
                    control.actualizarCancion(id);
                    break;

                case 3:
                   UIUtilities.clearScreen();
                    System.out.println("Introduce el id de la lista que quieras borrar");
                     id = UIUtilities.getInt();
                    control.borrarArtista(id);
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

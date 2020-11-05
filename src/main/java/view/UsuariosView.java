
package view;

import utils.UIUtilities;
import static utils.UIUtilities.espera;





/**
 *
 * @author Vinil
 */
public class UsuariosView {
    
        public static void usuarios() {
        int opcionusuario;
        do {
            System.out.println("Bienvenido al menu Usuarios");
            System.out.println("Seleccione una opción:");
            System.out.println("----------------------------");
            System.out.println("1.- Nuevo Usuario");
            System.out.println("2.- Editar Usuario");
            System.out.println("3.- Eliminar Usuario");
            System.out.println("4.- Listado de Usuarios");
            System.out.println("5.- Volver al menú principal");
            System.out.println("----------------------------");
            
            opcionusuario = UIUtilities.getInt();

            switch (opcionusuario) {

                case 1:
                    UIUtilities.clearScreen();
                    //nuevoUsuario();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    //editarUsuario();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    //borrarUsuario();
                    break;

                case 4:
                    UIUtilities.clearScreen();
                    //listarUsuario();
                    espera();
                    break;
        
                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opcionusuario != 5);
    }
    
}

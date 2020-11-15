
package view;

import Util.UIUtilities;
import static Util.UIUtilities.espera;
import com.mycompany.proyectoua2.model.Usuario;





/**
 *
 * @author Vinil
 */
public class UserView {
    Controller.Controlador control=new Controller.Controlador();
    int id;
        public  void usuarios() {
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
                    Usuario a = new Usuario();
                    System.out.println("Introduce el nombre");
                    String nombre = UIUtilities.getString();
                    a.setNombre(nombre);
                    System.out.println("Introduce el correo");
                    String correo = UIUtilities.getString();
                    a.setCorreo(correo);
                    System.out.println("Introduce la URL de la foto");
                    String foto = UIUtilities.getString();
                    a.setFoto(foto);
                    control.crearUsuario(a);
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del usuario que quieras editar");
                    id = UIUtilities.getInt();
                    control.actualizarUsuario(id);
                    break;


                case 3:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del usuario que quieras borrar");
                    int id = UIUtilities.getInt();
                    control.borrarUsuario(id);
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

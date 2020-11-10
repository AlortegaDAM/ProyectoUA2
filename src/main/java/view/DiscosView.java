/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Util.UIUtilities;
import static Util.UIUtilities.espera;




/**
 *
 * @author Vinil
 */
public class DiscosView {
    
        public static void discos() {
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
                    //nuevoDisco();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                   // editarDisco();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    //borrarDisco();
                    break;

                case 4:
                    UIUtilities.clearScreen();
                   // listarDisco();
                    espera();
                    break;
        
                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opciondisco != 5);
    }
    
}

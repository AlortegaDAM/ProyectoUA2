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
public class ArtistasView {
    
        public static void artistas() {
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
                   // nuevoArtista();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                   // editarArtista();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                  //  borrarArtista();
                    break;

                case 4:
                    UIUtilities.clearScreen();
                   //s listarArtista();
                    espera();
                    break;
        
                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opcionartista != 5);
    }
    
}

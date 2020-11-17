/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static Control.Controlador.crearArtistas;
import Util.UIUtilities;
import static Util.UIUtilities.espera;
import com.mycompany.proyectoua2.model.Artista;
import com.mycompany.proyectoua2.model.Cancion;
import com.mycompany.proyectoua2.model.Disco;
import com.mycompany.proyectoua2.model.Lista;
import com.mycompany.proyectoua2.model.Usuario;

/**
 *
 * @author Carlos
 */
public class viewAll {

    Control.Controlador control = new Control.Controlador();

    public  void mainView() {

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
                    artistas();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    canciones();
                    break;
                case 3:
                    UIUtilities.clearScreen();
                    discos();
                    break;
                case 4:
                    UIUtilities.clearScreen();
                    listasReproduccion();
                    break;
                case 5:
                    UIUtilities.clearScreen();
                    usuarios();
                case 6:
                    System.out.println("Saliendo del sistema de Reparto");

                    break;
                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }

        } while (opciones != 6);
    }

    public void artistas() {
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
                    crearArtistaM();
                    break;

                case 2:
                   editarArtistaM();

                    break;

                case 3:
                    borrarArtistaM();
                    break;

                case 4:
                    listArtist();

                    break;

                case 5:
                    mainView();
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opcionartista != 5);
    }

    public  void canciones() {
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
                    System.out.println("Introduce la duracion");
                     int duracion = UIUtilities.getInt();
                    a.setDuracion(duracion);
                    System.out.println("Introduce el ID del Disco");
                    int id = UIUtilities.getInt();
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
                    id = UIUtilities.getInt();
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

    public  void discos() {
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
                    Disco a = new Disco();
                    System.out.println("Introduce el nombre");
                    String nombre = UIUtilities.getString();
                    a.setNombre(nombre);
                    System.out.println("Introduce la foto");
                    String foto = UIUtilities.getString();
                    a.setFoto(foto);
                    System.out.println("Introduce fecha de publicacion");
                    //Fecha de publicacion
                    //  a.setFecha_produccion(duracion);             
                    //control.crearDisco(a);
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del disco que quieras editar");
                    int id = UIUtilities.getInt();
                    control.actualizarDisco(id);
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del disco que quieras borrar");
                    id = UIUtilities.getInt();
                    control.borrarDisco(id);
                    break;

                case 4:
                    UIUtilities.clearScreen();

                    break;

                case 5:
                    break;
                default:
                    System.out.println("Seleccione una opción válida");

            }
        } while (opciondisco != 5);
    }

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
                    //control.crearUsuario(a);
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del usuario que quieras editar");
                    int id = UIUtilities.getInt();
                    //control.actualizarUsuario(id);
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    System.out.println("Introduce el id del usuario que quieras borrar");
                    id = UIUtilities.getInt();
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

    public void listArtist() {
        int opcion = 0;

        do {
            System.out.println("Listado de Artistas");
            System.out.println("1)Listar todos los artistas");
            System.out.println("2)Listar todos los artistas por nombre");
            System.out.println("3)Listar todos los artistas por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                System.out.println(control.mostrarArtistas());
                break;
            case 2:
                System.out.println("Introduce el nombre del artista que quieras buscar");
                String nombre = UIUtilities.getString();
                System.out.println(control.buscarArtistaNombre(nombre));
                
                break;
            case 3:
                System.out.println("Introduce la ID del artista que quieras buscar");
                int id = UIUtilities.getInt();
                System.out.println(control.buscarArtistaID(id));
                
                break;
            case 4:
                artistas();
                break;
        }
    }

    public void listSong() {
        int opcion = 0;

        do {
            System.out.println("Listado de canciones");
            System.out.println("1)Listar todos los discos");
            System.out.println("2)Listar todos los discos por nombre");
            System.out.println("3)Listar todos los discos por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                control.mostrarDiscos();
                break;
            case 2:
                System.out.println("Introduce el nombre del disco que quieras buscar");
                String nombre = UIUtilities.getString();
                control.mostrarDiscosNombre(nombre);
                break;
            case 3:
                System.out.println("Introduce la ID del cancion que quieras buscar");
                int id = UIUtilities.getInt();
                control.buscarDiscoID(id);
                break;
            case 4:
                discos();
                break;
        }
    }

    public void listUser() {
        int opcion = 0;

        do {
            System.out.println("Listado de usuarios");
            System.out.println("1)Listar todos los listas");
            System.out.println("2)Listar todos los listas por nombre");
            System.out.println("3)Listar todos los listas por id");
            System.out.println("4)Volver atrás");
            opcion = UIUtilities.getInt();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                control.mostrarListas();
                break;
            case 2:
                System.out.println("Introduce el nombre de la lista que quieras buscar");
                String nombre = UIUtilities.getString();
                control.mostrarListasNombre(nombre);
                break;
            case 3:
                System.out.println("Introduce la ID del usuarios que quieras buscar");
                int id = UIUtilities.getInt();
                control.buscarListaID(id);
                break;
            case 4:
                listasReproduccion();
                break;
        }
    }

  

   

    public void crearArtistaM() {
        UIUtilities.clearScreen();

        System.out.println("Introduce el nombre");
        String nombre = UIUtilities.getString();
        System.out.println("Introduce la nacionalidad");
        String nacionalidad = UIUtilities.getString();
        System.out.println("Introduce la URL de la foto");
        String foto = UIUtilities.getString();
        Artista a = new Artista(nombre, nacionalidad, foto);
        crearArtistas(a);
    }
    
    public void editarArtistaM(){
         UIUtilities.clearScreen();
                    System.out.println("Introduce el id del artista  que quieras editar");
        int id = UIUtilities.getInt();
                    control.actualizarArtista(id);
    }
    public void borrarArtistaM(){
        UIUtilities.clearScreen();
                    System.out.println("Introduce el id del Artista que quieras borrar");
        int id = UIUtilities.getInt();
                    control.borrarArtista(id);
    }
    
    public void listarArtistaM(){
        
    }

}

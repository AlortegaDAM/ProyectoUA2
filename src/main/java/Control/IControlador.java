/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.mycompany.proyectoua2.model.Artista;
import com.mycompany.proyectoua2.model.Cancion;
import com.mycompany.proyectoua2.model.Comentario;
import com.mycompany.proyectoua2.model.Disco;
import com.mycompany.proyectoua2.model.Lista;
import com.mycompany.proyectoua2.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adryc
 */
public interface IControlador {
    //Controlador para los artistas
    List<Artista> mostrarArtistas();
    List<Artista> buscarArtistaNombre(String nombre);
    Artista buscarArtistaID(int id);
    void crearArtista(Artista a);
    void actualizarArtista(Artista a);
    void borrarArtista(int id);
    
    //Controlador para los discos
    List<Disco> mostrarDiscos();
    List<Disco> mostrarDiscosNombre(String nombre);
    Disco buscarDiscoID(int id);
    void crearDisco(Disco d);
    void actualizarDisco(Disco d);
    void borrarDisco(int id);
    void insertarCanciones(ArrayList<Cancion> canciones, Disco d);
    
    //Controlador para las canciones
    List<Cancion> mostrarCanciones();
    List<Cancion> mostrarCancionesNombre(String nombre);
    Cancion buscarCancionID(int id);
    void crearCancion(Cancion c);
    void actualizarCancion(Cancion c);
    void borrarCancion(int id);
    
    //Controlador para los usuarios
    List<Usuario> mostrarUsuarios();
    List<Usuario> mostrarUsuariosNombre(String nombre);
    Usuario buscarUsuarioID(int id);
    void crearUsuario(Usuario u);
    void actualizarUsuario(Usuario u);
    void borrarUsuario(int id);
    
    //Controlador para las listas
    List<Lista> mostrarListas();
    List<Lista> mostrarListasNombre(String nombre);
    Lista buscarListaID(int id);
    void crearLista(Lista l);
    void actualizarLista(Lista l);
    void borrarLista(int id);
    
    //Controlador para los comentarios
    List<Comentario> mostrarComentarios();
    List<Comentario> mostrarComentariosNombre(String nombre);
    Comentario buscarComentarioID(int id);
    void crearComentario(Comentario c);
    void actualizarComentario(Comentario c);
    void borrarComentario(int id);
}

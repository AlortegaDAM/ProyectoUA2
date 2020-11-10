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
    boolean crearArtista(Artista a);
    boolean actualizarArtista(Artista a);
    boolean borrarArtista(int id);
    
    //Controlador para los discos
    List<Disco> mostrarDiscos();
    List<Disco> mostrarDiscosNombre(String nombre);
    Disco buscarDiscoID(int id);
    boolean crearDisco(Disco d);
    boolean actualizarDisco(Disco d);
    boolean borrarDisco(int id);
    void insertarCanciones(ArrayList<Cancion> canciones, Disco d);
    
    //Controlador para las canciones
    List<Cancion> mostrarCanciones();
    List<Cancion> mostrarCancionesNombre(String nombre);
    Cancion buscarCancionID(int id);
    boolean crearCancion(Cancion c);
    boolean actualizarCancion(Cancion c);
    boolean borrarCancion(int id);
    boolean addCancionDisco(Cancion c, Disco d);
    
    //Controlador para los usuarios
    List<Usuario> mostrarUsuarios();
    List<Usuario> mostrarUsuariosNombre(String nombre);
    Usuario buscarUsuarioID(int id);
    boolean crearUsuario(Usuario u);
    boolean actualizarUsuario(Usuario u);
    boolean borrarUsuario(Usuario u);
    
    //Controlador para las listas
    List<Lista> mostrarListas();
    List<Lista> mostrarListasNombre(String nombre);
    Lista buscarListaID(int id);
    boolean crearLista(Lista l);
    boolean actualizarLista(Lista l);
    boolean borrarLista(Lista l);
    
    //Controlador para los comentarios
    List<Comentario> mostrarComentarios();
    List<Comentario> mostrarComentariosNombre(String nombre);
    Comentario buscarComentarioID(int id);
    boolean crearComentario(Comentario c);
    boolean actualizarComentario(Comentario c);
    boolean borrarComentario(Comentario c);
}

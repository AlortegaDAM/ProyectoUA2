/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCControl;

import com.mycompany.proyectoua2.model.Artista;
import com.mycompany.proyectoua2.model.Cancion;
import com.mycompany.proyectoua2.model.Comentario;
import com.mycompany.proyectoua2.model.Disco;
import com.mycompany.proyectoua2.model.Lista;
import com.mycompany.proyectoua2.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author adryc
 */
public interface IControlador {
    ArrayList<Artista> artistas = null;
    ArrayList<Disco> discos = null;
    ArrayList<Cancion> canciones = null;
    ArrayList<Lista> listas = null;
    ArrayList<Usuario> usuarios = null;
    ArrayList<Comentario> comentarios = null;
    
    ArrayList<Artista> listarArtistas();
    ArrayList<Artista> listarArtistasporPais(String pais);
    ArrayList<Artista> listarArtistasporNombre(String nombre);
    Artista buscarArtistaID (int id);
    ArrayList<Disco> listarDiscos();
    ArrayList<Disco> listarDiscosporArtista(Artista a);
    ArrayList<Disco> listarDiscosporNombre (String nombre);
    Disco buscarDiscoID (int id);
    ArrayList<Cancion> listarCanciones();
    ArrayList<Cancion> listarCancionesporNombre(String nombre);
    ArrayList<Cancion> listarCancionesporArtista(Artista a);
    ArrayList<Cancion> listarCancionesporDisco(Disco d);
    Cancion buscarCancionID(int id);
    ArrayList<Lista> listarListas();
    Lista buscarListaID(int id);
    ArrayList<Usuario> listarUsuarios();
    ArrayList<Usuario> listarUsuariosporNombre(String nombre);
    Usuario buscarUsuarioID(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ArtistaDao;
import Dao.CancionDao;
import Dao.ComentarioDao;
import Dao.DiscoDao;
import Dao.ListaDao;
import Dao.UsuarioDao;
import com.mycompany.proyectoua2.model.Artista;
import com.mycompany.proyectoua2.model.Cancion;
import com.mycompany.proyectoua2.model.Comentario;
import com.mycompany.proyectoua2.model.Disco;
import com.mycompany.proyectoua2.model.Lista;
import com.mycompany.proyectoua2.model.Usuario;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adryc
 */
public class Controlador implements IControlador{

    JDBCConector conex = new JDBCConector();
    Connection con = conex.createNewDBconnection();
    
    @Override
    public List<Artista> mostrarArtistas() {
        List<Artista> result = new ArrayList<>();
        ArtistaDao dao = new ArtistaDao();
        result = dao.getAll(con);
        return result;
    }

    @Override
    public List<Artista> buscarArtistaNombre(String nombre) {
         ArtistaDao dao = new ArtistaDao();
         List<Artista> result = new ArrayList<>();
         result = dao.getByName(con, nombre);
         return result;
    }

    @Override
    public Artista buscarArtistaID(int id) {
        List<Artista> aux = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        ArtistaDao dao = new ArtistaDao();
        Artista result = new Artista();
        aux = dao.getById(con, ids);
        result = aux.get(0);
        return result;
    }

    @Override
    public void crearArtista(Artista a) {
        ArtistaDao dao = new ArtistaDao(a);
        dao.save();
    }

    @Override
    public void actualizarArtista(Artista a) {
        ArtistaDao dao = new ArtistaDao(a);
        dao.save();
    }

    @Override
    public void borrarArtista(int id) {
        Artista deleted = buscarArtistaID(id);
        ArtistaDao dao = new ArtistaDao(deleted);
        dao.remove();
    }

    @Override
    public List<Disco> mostrarDiscos() {
        List<Disco> result = new ArrayList<>();
        DiscoDao dao = new DiscoDao();
        result = dao.getAll(con);
        return result;
    }

    @Override
    public List<Disco> mostrarDiscosNombre(String nombre) {
         DiscoDao dao = new DiscoDao();
         List<Disco> result = new ArrayList<>();
         result = dao.getByName(con, nombre);
         return result;
    }

    @Override
    public Disco buscarDiscoID(int id) {
        List<Disco> aux = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        DiscoDao dao = new DiscoDao();
        Disco result = new Disco();
        aux = dao.getById(con, ids);
        result = aux.get(0);
        return result;
    }

    @Override
    public void crearDisco(Disco d) {
        DiscoDao dao = new DiscoDao(d);
        dao.save();
            
    }
    

    @Override
    public void actualizarDisco(Disco d) {
        DiscoDao dao = new DiscoDao(d);
        dao.save();
    }

    @Override
    public void borrarDisco(int id) {
        Disco deleted = buscarDiscoID(id);
        DiscoDao dao = new DiscoDao(deleted);
        dao.remove();
    }

    @Override
    public void insertarCanciones(ArrayList<Cancion> canciones, Disco d) {
        DiscoDao dao = new DiscoDao(d);
        CancionDao dao2 = new CancionDao();
        for(Cancion c : canciones){
            dao2 = new CancionDao(c);
            c.setId_disco(d.getId());
        }
        d.setCanciones(canciones);
    }

    @Override
    public List<Cancion> mostrarCanciones() {
       List<Cancion> result = new ArrayList<>();
       CancionDao dao = new CancionDao();
       result = dao.getAll(con);
       return result;
    }

    @Override
    public List<Cancion> mostrarCancionesNombre(String nombre) {
       List<Cancion> result = new ArrayList<>();
       CancionDao dao = new CancionDao();
       result = dao.getByName(con, nombre);
       return result;
    }

    @Override
    public Cancion buscarCancionID(int id) {
        List<Cancion> aux = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        CancionDao dao = new CancionDao();
        Cancion result = new Cancion();
        aux = dao.getById(con, ids);
        result = aux.get(0);
        return result;
    }

    @Override
    public void crearCancion(Cancion c) {
        CancionDao dao = new CancionDao(c);
        dao.save();
    }

    @Override
    public void actualizarCancion(Cancion c) {
        CancionDao dao = new CancionDao(c);
        dao.save();
    }

    @Override
    public void borrarCancion(int id) {
        Cancion removed = buscarCancionID(id);
        CancionDao dao = new CancionDao(removed);
        dao.remove();
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        List<Usuario> result = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        result = dao.getAll(con);
        return result;
    }

    @Override
    public List<Usuario> mostrarUsuariosNombre(String nombre) {
        List<Usuario> result = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        result = dao.getByName(con, nombre);
        return result;
    }

    @Override
    public Usuario buscarUsuarioID(int id) {
        List<Usuario> aux = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        UsuarioDao dao = new UsuarioDao();
        Usuario result = new Usuario();
        aux = dao.getById(con, ids);
        result = aux.get(0);
        return result;
    }

    @Override
    public void crearUsuario(Usuario u) {
        UsuarioDao dao = new UsuarioDao(u);
        dao.save();
    }

    @Override
    public void actualizarUsuario(Usuario u) {
        UsuarioDao dao = new UsuarioDao(u);
        dao.save();   
    }

    @Override
    public void borrarUsuario(int id) {
        UsuarioDao dao = new UsuarioDao();
        Usuario removed = buscarUsuarioID(id);
        dao = new UsuarioDao(removed);
        dao.remove();
    }

    @Override
    public List<Lista> mostrarListas() {
        List<Lista> result = new ArrayList<>();
        ListaDao dao = new ListaDao();
        result = dao.getAll(con);
        return result;
    }

    @Override
    public List<Lista> mostrarListasNombre(String nombre) {
        List<Lista> result = new ArrayList<>();
        ListaDao dao = new ListaDao();
        result = dao.getByName(con, nombre);
        return result;
    }

    @Override
    public Lista buscarListaID(int id) {
        List<Lista> aux = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        ListaDao dao = new ListaDao();
        Lista result = new Lista();
        aux = dao.getById(con, ids);
        result = aux.get(0);
        return result;
    }

    @Override
    public void crearLista(Lista l) {
        ListaDao dao = new ListaDao(l);
        dao.save();
    }

    @Override
    public void actualizarLista(Lista l) {
        ListaDao dao = new ListaDao(l);
        dao.save();    
    }

    @Override
    public void borrarLista(int id) {
        Lista removed = buscarListaID(id);
        ListaDao dao = new ListaDao(removed);
        dao.remove();
    }

    @Override
    public List<Comentario> mostrarComentarios() {
        List<Comentario> result = new ArrayList<>();
        ComentarioDao dao = new ComentarioDao();
        result = dao.getAll(con);
        return result;
    }

    @Override
    public List<Comentario> mostrarComentariosNombre(String nombre) {
        List<Comentario> result = new ArrayList<>();
        ComentarioDao dao = new ComentarioDao();
        result = dao.getByName(con, nombre);
        return result;
    }

    @Override
    public Comentario buscarComentarioID(int id) {
        ComentarioDao dao = new ComentarioDao();
        Comentario result = new Comentario();
        List<Comentario> aux = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        aux = dao.getById(con, ids);
        result = aux.get(0);
        return result;
    }

    @Override
    public void crearComentario(Comentario c) {
        ComentarioDao dao = new ComentarioDao(c);
        dao.save();
    }

    @Override
    public void actualizarComentario(Comentario c) {
        ComentarioDao dao = new ComentarioDao(c);
        dao.save();
    }

    @Override
    public void borrarComentario(int id) {
        Comentario removed = buscarComentarioID(id);
        ComentarioDao dao= new ComentarioDao(removed);
        dao.remove();
    }
    
    
}

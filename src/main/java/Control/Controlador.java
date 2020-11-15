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
        ArtistaDao dao = new ArtistaDao();
        Artista result = dao.getById(con, id);
        return result;
    }

    @Override
    public void crearArtista(Artista a) {
        ArtistaDao nuevoDao=new ArtistaDao(a);
        nuevoDao.save();
        a.setId(nuevoDao.getId());
    }

    @Override
    public void actualizarArtista(int id) {
        ArtistaDao dao = new ArtistaDao();
        Artista a = buscarArtistaID(id);
        dao = new ArtistaDao(a);
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
        DiscoDao dao = new DiscoDao();
        Disco result = dao.getById(con, id);
        return result;
    }

    @Override
    public void crearDisco(Disco d) {
        DiscoDao dao = new DiscoDao(d);
        dao.save();
            
    }
    

    @Override
    public void actualizarDisco(int id) {
        DiscoDao dao = new DiscoDao();
        Disco d = buscarDiscoID(id);
        dao = new DiscoDao(d);
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
        CancionDao dao = new CancionDao();
        Cancion result = dao.getById(con, id);
        return result;
    }

    @Override
    public void crearCancion(Cancion c) {
        CancionDao dao = new CancionDao(c);
        dao.save();
    }

    @Override
    public void actualizarCancion(int id) {
        CancionDao dao = new CancionDao();
        Cancion c = buscarCancionID(id);
        dao = new CancionDao(c);
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

        UsuarioDao dao = new UsuarioDao();
        Usuario result = dao.getById(con, id);
        return result;
    }

    @Override
    public void crearUsuario(Usuario u) {
        UsuarioDao dao = new UsuarioDao(u);
        dao.save();
    }

    @Override
    public void actualizarUsuario(int id) {
        UsuarioDao dao = new UsuarioDao();
        Usuario u = buscarUsuarioID(id);
        dao = new UsuarioDao(u);
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
        Lista result = new Lista();
        ListaDao dao = new ListaDao();
        result = dao.getById(con, id);
        return result;
    }

    @Override
    public void crearLista(Lista l) {
        ListaDao dao = new ListaDao(l);
        dao.save();
    }

    @Override
    public void actualizarLista(int id) {
        ListaDao dao = new ListaDao();
        Lista l = buscarListaID(id);
        dao = new ListaDao();
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
        Comentario result = dao.getById(con, id);
        return result;
    }

    @Override
    public void crearComentario(Comentario c) {
        ComentarioDao dao = new ComentarioDao(c);
        dao.save();
    }

    @Override
    public void actualizarComentario(int id) {
        ComentarioDao dao = new ComentarioDao();
        Comentario c = buscarComentarioID(id);
        dao = new ComentarioDao(c);
        dao.save();
    }

    @Override
    public void borrarComentario(int id) {
        Comentario removed = buscarComentarioID(id);
        ComentarioDao dao= new ComentarioDao(removed);
        dao.remove();
    }

    @Override
    public List<Cancion> songsByDisk(int id) {
        List<Cancion> result = new ArrayList<>();
        List<Cancion> aux = mostrarCanciones();
        for(Cancion c : aux){
            if(c.getId_disco() == id){
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public List<Disco> diskByArtist(int id) {
        List<Disco> result = new ArrayList<>();
        ArtistaDao dao = new ArtistaDao();
        List<Disco> aux = mostrarDiscos();
        for(Disco d : aux){
            if(d.getId_artista() == id){
                result.add(d);
            }
        }
        return result;
    }

    @Override
    public void addSongToList(int songid, int listid) {
        Lista l = buscarListaID(listid);
        ListaDao dao = new ListaDao(l);
        dao.saveList_Song(songid);
    }

   @Override
    public List<Cancion> getSongsByList(int listid) {
        List<Cancion> result = new ArrayList<>();
        Lista l = buscarListaID(listid);
        ListaDao dao = new ListaDao(l);
        result = dao.getAllSongs(con, listid);
        return result;
    }
    
    
    
    
}

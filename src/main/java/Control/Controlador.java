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
import Util.UIUtilities;
import com.mycompany.proyectoua2.model.Artista;
import com.mycompany.proyectoua2.model.Cancion;
import com.mycompany.proyectoua2.model.Comentario;
import com.mycompany.proyectoua2.model.Disco;
import com.mycompany.proyectoua2.model.Lista;
import com.mycompany.proyectoua2.model.Usuario;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adryc
 */
public class Controlador implements IControlador{

    JDBCConector conex = new JDBCConector();
    Connection con = conex.createNewDBconnection();
    
    
    /*
    show all artists function
     * @return List of all Artists
    */
    
    @Override
    public List<Artista> mostrarArtistas() {
        List<Artista> result = new ArrayList<>();
        ArtistaDao dao = new ArtistaDao();
        result = dao.getAll(con);
        return result;
    }
    
    /**
     * search artists by name
     * @param nombre
     * @return List of artists by name
     */
    @Override
    public List<Artista> buscarArtistaNombre(String nombre) {
         ArtistaDao dao = new ArtistaDao();
         List<Artista> result = new ArrayList<>();
         result = dao.getByName(con, nombre);
         return result;
    }
/**
 * search artist by id
 * @param id
 * @return Artista
 */
    @Override
    public Artista buscarArtistaID(int id) {
        ArtistaDao dao = new ArtistaDao();
        Artista result = dao.getById(con, id);
        return result;
    }

   /**
    * create artist in database
    * @param a 
    */
    public static void crearArtistas(Artista a) {
        ArtistaDao nuevoDao=new ArtistaDao(a);
        nuevoDao.save();
        a.setId(nuevoDao.getId());
    }
/**
 * update artist by his id
 * @param id 
 */
    @Override
    public void actualizarArtista(int id) {
        Artista d = buscarArtistaID(id);
        System.out.println("Introduce el nombre");
        d.setNombre(UIUtilities.getString());
        System.out.println("Introduce la nacionalidad");
        d.setNacionalidad(UIUtilities.getString()); 
        System.out.println("Introduce la Url de la foto");
        d.setFoto(UIUtilities.getString());
        ArtistaDao dao = new ArtistaDao(d);
        dao.save();
    }
    
    
/**
 * delete artist by id
 * @param id 
 */
    @Override
    public void borrarArtista(int id) {
        Artista deleted = buscarArtistaID(id);
        ArtistaDao dao = new ArtistaDao(deleted);
        dao.remove();
    }
    
    /**
     * 
     * @param id 
     */
    public void borrarArtistas(int id) {
        Artista deleted = buscarArtistaID(id);
        ArtistaDao dao = new ArtistaDao(deleted);
        dao.remove();
    }
/**
 * Show All Disks
 * @return List of Disks
 */
    @Override
    public List<Disco> mostrarDiscos() {
        List<Disco> result = new ArrayList<>();
        DiscoDao dao = new DiscoDao();
        result = dao.getAll(con);
        return result;
    }
    /**
     * Disks by name
     * @param nombre as name of Disk
     * @return List of Disks that called "nombre"
     */
    @Override
    public List<Disco> mostrarDiscosNombre(String nombre) {
         DiscoDao dao = new DiscoDao();
         List<Disco> result = new ArrayList<>();
         result = dao.getByName(con, nombre);
         return result;
    }
/**
 * Search disk by id
 * @param id
 * @return Disk 
 */
    @Override
    public Disco buscarDiscoID(int id) {
        DiscoDao dao = new DiscoDao();
        Disco result = dao.getById(con, id);
        return result;
    }
/**
 * Create Disk
 * @param d Disco
 */
    @Override
    public void crearDisco(Disco d) {
        
        DiscoDao dao = new DiscoDao(d);
        dao.save();
            
    }
    
    
/**
 * Update Disk by id
 * @param id 
 */
    @Override
    public void actualizarDisco(int id) {
        Disco d = buscarDiscoID(id);
        System.out.println("Introduce el nombre");
        d.setNombre(UIUtilities.getString());
        System.out.println("Introduce la foto");
        d.setFoto(UIUtilities.getString()); 
        System.out.println("Introduce el id de Artista");
        d.setId_artista(UIUtilities.getInt());
        System.out.println("Introduce la fecha: Año, mes y dia");
        int year = UIUtilities.getInt();
        int month = UIUtilities.getInt();
        int day = UIUtilities.getInt();
        LocalDate fecha = LocalDate.of(year, month, day);
        d.setFecha_produccion(fecha);
        DiscoDao dao = new DiscoDao(d);
        dao.save();
    }
/**
 * Delete Disk by id
 * @param id 
 */
    @Override
    public void borrarDisco(int id) {
        Disco deleted = buscarDiscoID(id);
        DiscoDao dao = new DiscoDao(deleted);
        dao.remove();
    }
/**
 * New Songs into Disk
 * @param canciones as List of Cancion
 * @param d as Disco
 */
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
/**
 * Show Songs
 * @return List of songs
 */
    @Override
    public List<Cancion> mostrarCanciones() {
       List<Cancion> result = new ArrayList<>();
       CancionDao dao = new CancionDao();
       result = dao.getAll(con);
       return result;
    }
/**
 * Show Songs by name
 * @param nombre
 * @return Song who have that name
 */
    @Override
    public List<Cancion> mostrarCancionesNombre(String nombre) {
       List<Cancion> result = new ArrayList<>();
       CancionDao dao = new CancionDao();
       result = dao.getByName(con, nombre);
       return result;
    }
/**
 * Find Song by id
 * @param id
 * @return Song that have that id
 */
    @Override
    public Cancion buscarCancionID(int id) {
        CancionDao dao = new CancionDao();
        Cancion result = dao.getById(con, id);
        return result;
    }
/**
 * New Song in database
 * @param c as Song
 */
    @Override
    public void crearCancion(Cancion c) {
        CancionDao dao = new CancionDao(c);
        dao.save();
    }
/**
 * Update Song by id
 * @param id 
 */
    @Override
    public void actualizarCancion(int id) {
        CancionDao dao = new CancionDao();
        Cancion c = buscarCancionID(id);
        dao = new CancionDao(c);
        dao.save();
    }
/**
 * Delete Song by id
 * @param id 
 */
    @Override
    public void borrarCancion(int id) {
        Cancion removed = buscarCancionID(id);
        CancionDao dao = new CancionDao(removed);
        dao.remove();
    }
/**
 * Show Users
 * @return List of All Users
 */
    @Override
    public List<Usuario> mostrarUsuarios() {
        List<Usuario> result = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        result = dao.getAll(con);
        return result;
    }
/**
 * Show Users by name
 * @param nombre as name
 * @return User
 */
    @Override
    public List<Usuario> mostrarUsuariosNombre(String nombre) {
        List<Usuario> result = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        result = dao.getByName(con, nombre);
        return result;
    }
/**
 * Find User by id
 * @param id
 * @return User
 */
    @Override
    public Usuario buscarUsuarioID(int id) {

        UsuarioDao dao = new UsuarioDao();
        Usuario result = dao.getById(con, id);
        return result;
    }
/**
 * Create User in database
 * @param u as User
 */
    @Override
    public void crearUsuario(Usuario u) {
        UsuarioDao dao = new UsuarioDao(u);
        dao.save();
    }
/**
 * Update User by id
 * @param id 
 */
    @Override
    public void actualizarUsuario(int id) {
        UsuarioDao dao = new UsuarioDao();
        Usuario u = buscarUsuarioID(id);
        dao = new UsuarioDao(u);
        dao.save();   
    }
/**
 * Delete User by id
 * @param id 
 */
    @Override
    public void borrarUsuario(int id) {
        UsuarioDao dao = new UsuarioDao();
        Usuario removed = buscarUsuarioID(id);
        dao = new UsuarioDao(removed);
        dao.remove();
    }
/**
 * Show Lists
 * @return List of Lists
 */
    @Override
    public List<Lista> mostrarListas() {
        List<Lista> result = new ArrayList<>();
        ListaDao dao = new ListaDao();
        result = dao.getAll(con);
        return result;
    }
/**
 * Lists by name
 * @param nombre as name of List
 * @return List of Lists
 */
    @Override
    public List<Lista> mostrarListasNombre(String nombre) {
        List<Lista> result = new ArrayList<>();
        ListaDao dao = new ListaDao();
        result = dao.getByName(con, nombre);
        return result;
    }
/**
 * Find List by id
 * @param id
 * @return List
 */
    @Override
    public Lista buscarListaID(int id) {
        Lista result = new Lista();
        ListaDao dao = new ListaDao();
        result = dao.getById(con, id);
        return result;
    }
/**
 * Create new List in database
 * @param l as List
 */
    @Override
    public void crearLista(Lista l) {
        ListaDao dao = new ListaDao(l);
        dao.save();
    }
/**
 * UpdateList by id
 * @param id 
 */
    @Override
    public void actualizarLista(int id) {
        ListaDao dao = new ListaDao();
        Lista l = buscarListaID(id);
        dao = new ListaDao();
        dao.save();    
    }
    
    
/**
 * Delete List by id
 * @param id 
 */
    @Override
    public void borrarLista(int id) {
        Lista removed = buscarListaID(id);
        ListaDao dao = new ListaDao(removed);
        dao.remove();
    }
/**
 * Get comments
 * @return List of comments
 */
    @Override
    public List<Comentario> mostrarComentarios() {
        List<Comentario> result = new ArrayList<>();
        ComentarioDao dao = new ComentarioDao();
        result = dao.getAll(con);
        return result;
    }
/**
 * Show comment by name
 * @param nombre
 * @return Comment
 */
    @Override
    public List<Comentario> mostrarComentariosNombre(String nombre) {
        List<Comentario> result = new ArrayList<>();
        ComentarioDao dao = new ComentarioDao();
        result = dao.getByName(con, nombre);
        return result;
    }
/**
 * Find Comment by id
 * @param id
 * @return Comment
 */
    @Override
    public Comentario buscarComentarioID(int id) {
        ComentarioDao dao = new ComentarioDao();
        Comentario result = dao.getById(con, id);
        return result;
    }
/**
 * Create Comment in database
 * @param c as Comment
 */
    @Override
    public void crearComentario(Comentario c) {
        ComentarioDao dao = new ComentarioDao(c);
        dao.save();
    }
/**
 * Update Comment by id
 * @param id 
 */
    @Override
    public void actualizarComentario(int id) {
        ComentarioDao dao = new ComentarioDao();
        Comentario c = buscarComentarioID(id);
        dao = new ComentarioDao(c);
        dao.save();
    }
/**
 * Delete Comment by id
 * @param id 
 */
    @Override
    public void borrarComentario(int id) {
        Comentario removed = buscarComentarioID(id);
        ComentarioDao dao= new ComentarioDao(removed);
        dao.remove();
    }
/**
 * Show Songs in Disk by id
 * @param id as Disk id
 * @return List of Songs
 */
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
/**
 * Show Disk who have an Artist
 * @param id as Artist id
 * @return List of Disks
 */
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
/**
 * Add Song to List
 * @param songid as Song id
 * @param listid as List id
 */
    @Override
    public void addSongToList(int songid, int listid) {
        Lista l = buscarListaID(listid);
        ListaDao dao = new ListaDao(l);
        dao.saveList_Song(songid, con);
    }
/**
 * Show Songs into an List by id
 * @param listid as List id
 * @return List of Songs
 */
   @Override
    public List<Cancion> getSongsByList(int listid) {
        List<Cancion> result = new ArrayList<>();
        Lista l = buscarListaID(listid);
        ListaDao dao = new ListaDao(l);
        result = dao.getAllSongs(con, listid);
        return result;
    }
/**
 * Create Artist in database
 * @param a as Artist
 */
    @Override
    public void crearArtista(Artista a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}

    
    
    


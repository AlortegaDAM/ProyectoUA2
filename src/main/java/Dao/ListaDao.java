/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.mycompany.proyectoua2.model.Lista;
import Control.JDBCConector;
import com.mycompany.proyectoua2.model.Cancion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ListaDao extends com.mycompany.proyectoua2.model.Lista implements Dao {

    enum queries {
        INSERT("INSERT INTO lista (Nombre,Descripcion,ID_Usuario) VALUES (?,?,?)"),
        ALL("SELECT * FROM lista"),
        GETBYID("SELECT * FROM lista WHERE ID=?"),
        FINDBYNAME("SELECT * FROM lista WHERE Nombre LIKE ?"),
        INSERTSONGLIST("INSERT INTO lista_cancion (ID_Lista, ID_Cancion) VALUES (?,?)"),
        GETSONGS("SELECT can.* FROM cancion can"
                + "INNER JOIN lista_cancion lc ON lc.ID_Cancion=can.ID "
                + "INNER JOIN lista l ON lc.ID_Lista=l.ID "
                + "WHERE l.ID=?"),
        UPDATE("UPDATE lista SET Nombre = ?, Descripcion = ? WHERE ID = ?"),
        REMOVE("DELETE FROM lista WHERE ID=?");
        private String q;

        queries(String q) {
            this.q = q;
        }

        public String getQ() {
            return this.q;
        }
    }

    Connection con;
    private boolean persist;
    JDBCConector conex = new JDBCConector();

    public ListaDao(int id, String nombre, String descripcion, int id_usuario) {
        super(nombre, descripcion, id_usuario);
        con = conex.createNewDBconnection();
        persist = false;
    }

    public ListaDao() {
        super();
        con = conex.createNewDBconnection();

        persist = false;
    }

    //DAO
    public ListaDao(Lista a) {
        this(a.getId(), a.getNombre(), a.getDescripcion(), a.getId_usuario());
    }

    public ListaDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.GETBYID.getQ(), params);

            if (rs != null) {

                while (rs.next()) {
                    Lista c = instanceBuilder(rs);
                    this.id = c.getId();
                    this.nombre = c.getNombre();
                    this.descripcion = c.getDescripcion();
                    this.id_usuario = c.getId_usuario();
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar lista");
        }
    }

    @Override
    public void persist() {
        this.persist = true;
    }

    @Override
    public void detach() {
        this.persist = false;
    }

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
        if (persist) {
            save();
        }
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
        if (persist) {
            save();
        }
    }

    public static List<Cancion> getAllSongs(Connection con, int idlista) {
        List<Cancion> result = new ArrayList<>();
        Cancion c = new Cancion();
        String sqlp = "SELECT T1.ID_Cancion, T2.ID, T2.Nombre, T2.Duracion, T2.ID_Disco\n"
                + "FROM lista_cancion T1, cancion T2\n"
                + "WHERE T1.ID_Cancion =  T2.ID\n"
                + "    AND T1.ID_Lista = ?";
        ResultSet rs;
        try {
            //establecer conexion
            //con=cn.Conectar();
            //preparación de la sentencia SQL
            PreparedStatement ps;
            ps = con.prepareStatement(sqlp);
            ps.setInt(1, idlista);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setDuracion(rs.getInt("Duracion"));
                c.setId_disco(rs.getInt("ID_Disco"));
                result.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void setId(int id) {
        /*super.setId(id); 
        if(persist){
            save();
        }*/
        //primary key cannot be changed
    }

    @Override
    public void save() {
        queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getNombre());
        params.add(this.getDescripcion());
        params.add(this.getId_usuario());

        if (this.id == -1) {
            q = queries.INSERT;
        } else {
            q = queries.UPDATE;
            params.add(this.id);
        }

        try {
            //Comienza transacción
            con.setAutoCommit(false);

            int rs = Util.ConnectionUtil.execUpdate(con, q.getQ(), params, (q == queries.INSERT ? true : false));
            if (q == ListaDao.queries.INSERT) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar lista");
        }

    }

    /*
    public void saveList_Song(int id_cancion) {
        queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getId());
        params.add(id_cancion);

        q = queries.INSERTSONGLIST;

        try {
            //Comienza transacción
            con.setAutoCommit(false);
            int rs = Util.ConnectionUtil.execUpdate(con, q.getQ(), params, (q == queries.INSERTSONGLIST ? true : false));
            if (q == ListaDao.queries.INSERTSONGLIST) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar lista");
        }

    }
     */

    public void remove() {
        if (this.id != -1) {
            try {
                //Comienza transacción
                con.setAutoCommit(false);

                int rs = Util.ConnectionUtil.execUpdate(con, queries.REMOVE.getQ(), this.id, false);

                //Fin de la transacción
                con.commit();
                con.setAutoCommit(true);

            } catch (SQLException ex) {
                System.out.println("Error al borrar lista");
            }
        }
    }
    // UTILS for CONTACT DAO

    public static Lista instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        Lista c = new Lista();
        if (rs != null) {
            try {

                c.setId(rs.getInt("ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setDescripcion(rs.getString("Descripcion"));
                c.setId_usuario(rs.getInt("ID_Usuario"));

                //falta lazy contacts
            } catch (SQLException ex) {
                System.out.println("Error SQL al crear un lista");

            }

        }
        return c;
    }

    public static List<Lista> getAll(Connection con) {
        List<Lista> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.ALL.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("prueba0");
                    Lista n = ListaDao.instanceBuilder(rs);
                    System.out.println("prueba1");
                    result.add(n);
                    System.out.println(n);

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al cargar lista");
        }
        return result;
    }

    public static List<Cancion> getAllSongs(Connection con) {
        List<Cancion> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.GETSONGS.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    Cancion n = CancionDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar lista");
        }
        return result;
    }

    public static List<Lista> getByName(Connection con, String name) {
        List<Lista> result = new ArrayList<>();
        try {

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.FINDBYNAME.getQ(), name + "%");
            if (rs != null) {
                while (rs.next()) {
                    Lista n = ListaDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar lista");
        }
        return result;
    }

    public static Lista getById(Connection con, int id) {
        Lista result = new Lista();
        String consulta = "SELECT * FROM lista where ID =?";
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("ID"));
                result.setNombre(rs.getString("Nombre"));
                result.setDescripcion(rs.getString("Descripcion"));
                result.setId_usuario(rs.getInt("ID_Usuario"));

            }

        } catch (SQLException ex) {
            System.out.println("Error al cargar lista");
        }
        return result;
    }

    public void saveList_Song(int id_cancion) {
        List<Cancion> result = new ArrayList<>();
        Cancion c = new Cancion();
        String sqlp = "SELECT ID_Cancion FROM lista_cancion where ID_Lista=?";
        String del = "DELETE from lista_cancion where ID_Lista=?";
        String ins = "INSERT INTO lista_cancion (ID_Lista, ID_Cancion) values(?,?)";
        ResultSet rs;
        try {

            //preparación de la sentencia SQL que nos traerá los registros de la tabla n:M
            PreparedStatement ps;
            ps = con.prepareStatement(sqlp);
            System.out.println(con);
            ps.setInt(1, this.id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                result.add(c);
            }
            c.setId(id_cancion);
            result.add(c);
            //Borro registros de la tabla n:m
            PreparedStatement ps2;
            ps2 = con.prepareStatement(del);
            ps2.setInt(1, this.id);
            ps2.executeUpdate();

            for (int i = 0; i < result.size(); i++) {
                PreparedStatement ps3;
                ps3 = con.prepareStatement(ins);
                ps3.setInt(1, this.id);
                ps3.setInt(2, result.get(i).getId());

                ps3.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        c.setId(id_cancion);
        result.add(c);
    }

}

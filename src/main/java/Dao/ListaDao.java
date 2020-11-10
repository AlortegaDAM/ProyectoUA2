/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.mycompany.proyectoua2.model.Lista;
import Control.JDBCConector;
import java.sql.Connection;
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
        INSERT("INSERT INTO lista (ID,Nombre,Descripcion,ID_Usuario) VALUES (?,?,?,?)"),
        ALL("SELECT * FROM lista"),
        GETBYID("SELECT * FROM lista WHERE ID=?"),
        FINDBYNAME("SELECT * FROM lista WHERE Nombre LIKE ?"),
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
        super(id, nombre, descripcion, id_usuario);
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

    public void persist() {
        this.persist = true;
    }

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

    @Override
    public void setId(int id) {
        /*super.setId(id); 
        if(persist){
            save();
        }*/
        //primary key cannot be changed
    }

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
                    Lista n = ListaDao.instanceBuilder(rs);
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

    public static List<Lista> getById(Connection con, List<Integer> ids) {
        List<Lista> result = new ArrayList<>();
        try {
            List<String> newList = new ArrayList<String>(ids.size());
            for (Integer myInt : ids) {
                newList.add(String.valueOf(myInt));
            }
            String queryTotal = queries.GETBYID.getQ() + "(" + String.join(",", newList) + ");";

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queryTotal, null);
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

}

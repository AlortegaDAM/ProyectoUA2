/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.mycompany.proyectoua2.model.Usuario;
import Control.JDBCConector;
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
public class UsuarioDao extends com.mycompany.proyectoua2.model.Usuario implements Dao {

    enum queries {
        INSERT("INSERT INTO usuario (Correo,Nombre,Foto) VALUES (?,?,?)"),
        ALL("SELECT * FROM usuario"),
        GETBYID("SELECT * FROM usuario WHERE ID=?"),
        FINDBYNAME("SELECT * FROM usuario WHERE Nombre LIKE ?"),
        UPDATE("UPDATE usuario SET Correo = ?, Nombre = ?, Foto = ? WHERE ID = ?"),
        REMOVE("DELETE FROM usuario WHERE ID=?");
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

    public UsuarioDao(int id, String nombre, String correo, String foto) {
        super(nombre, correo, foto);
        con = conex.createNewDBconnection();
        persist = false;
    }

    public UsuarioDao() {
        super();
        con = conex.createNewDBconnection();

        persist = false;
    }

    //DAO
    public UsuarioDao(Usuario a) {
        this(a.getId(), a.getNombre(), a.getCorreo(), a.getFoto());
    }

    public UsuarioDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.GETBYID.getQ(), params);

            if (rs != null) {

                while (rs.next()) {
                    Usuario c = instanceBuilder(rs);
                    this.id = c.getId();
                    this.nombre = c.getNombre();
                    this.correo = c.getCorreo();
                    this.foto = c.getFoto();
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar usuario");
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
    public void setFoto(String foto) {
        super.setFoto(foto);
        if (persist) {
            save();
        }
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
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

    @Override
    public void save() {
        queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getCorreo());
        params.add(this.getNombre());
        params.add(this.getFoto());

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
            if (q == UsuarioDao.queries.INSERT) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar usuario");
        }

    }

    @Override
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
                System.out.println("Error al borrar Usuario");
            }
        }
    }

    // UTILS for CONTACT DAO
    public static Usuario instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        Usuario c = new Usuario();
        if (rs != null) {
            try {
                c.setId(rs.getInt("ID"));
                c.setCorreo(rs.getString("Correo"));
                c.setNombre(rs.getString("Nombre"));
                c.setFoto(rs.getString("Foto"));

                //falta lazy contacts
            } catch (SQLException ex) {
                System.out.println("Error SQL al crear un usuario");

            }

        }
        return c;
    }

    public static List<Usuario> getAll(Connection con) {
        List<Usuario> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.ALL.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    Usuario n = UsuarioDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar usuario");
        }
        return result;
    }

    public static List<Usuario> getByName(Connection con, String name) {
        List<Usuario> result = new ArrayList<>();
        try {

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.FINDBYNAME.getQ(), name + "%");
            if (rs != null) {
                while (rs.next()) {
                    Usuario n = UsuarioDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar usuario");
        }
        return result;
    }

    public static Usuario getById(Connection con, int id) {
        Usuario result = new Usuario();
        String consulta = "SELECT * FROM disco where ID =?";
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("ID"));
                result.setCorreo(rs.getString("Correo"));
                result.setNombre(rs.getString("Nombre"));
                result.setFoto(rs.getString("Foto"));

            }

        } catch (SQLException ex) {
            System.out.println("Error al cargar artista");
        }
        return result;
    }

}

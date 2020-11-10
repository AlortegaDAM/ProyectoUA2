/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import com.mycompany.proyectoua2.model.Artista;
import JDBCControl.JDBCConector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Carlos
 */
public class ArtistaDao extends com.mycompany.proyectoua2.model.Artista implements Dao {

    enum queries {
        INSERT("INSERT INTO artista (ID,Nombre,Nacionalidad,Foto) VALUES (?,?,?,?)"),
        ALL("SELECT * FROM artista"),
        GETBYID("SELECT * FROM artista WHERE id=?"),
        FINDBYNAME("SELECT * FROM artista WHERE nombre LIKE ?"),
        UPDATE("UPDATE artista SET nombre = ?, nacionalidad = ? WHERE id = ?,SET foto = ?"),
        REMOVE("DELETE FROM artista WHERE id=?");
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

    public ArtistaDao(int id, String nombre, String nacionalidad, String foto) {
        super(id, nombre, nacionalidad, foto);
        con = conex.createNewDBconnection();
        persist = false;
    }

    public ArtistaDao() {
        super();
        con = conex.createNewDBconnection();
        
        persist = false;
    }

    //DAO
    public ArtistaDao(Artista a) {
        this(a.getId(), a.getNombre(), a.getNacionalidad(), a.getFoto());
    }

    public ArtistaDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.GETBYID.getQ(), params);

            if (rs != null) {

                while (rs.next()) {
                    Artista c = instanceBuilder(rs);
                    this.id = c.getId();
                    this.nombre = c.getNombre();
                    this.nacionalidad = c.getNacionalidad();
                    this.foto = c.getFoto();
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Artista");
        }
    }

    public void persist() {
        this.persist = true;
    }

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
    public void setNacionalidad(String nacionalidad) {
        super.setNacionalidad(nacionalidad);
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
        params.add(this.getNacionalidad());
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
            if (q == ArtistaDao.queries.INSERT) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar Artista");
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
                System.out.println("Error al borrar Artista");
            }
        }
    }

    // UTILS for CONTACT DAO
    public static Artista instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        Artista c = new Artista();
        if (rs != null) {
            try {
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setNacionalidad(rs.getString("nacionalidad"));
                c.setFoto(rs.getString("foto"));

                //falta lazy contacts
            } catch (SQLException ex) {
                System.out.println("Error SQL al crear un Artista");

            }

        }
        return c;
    }

    public static List<Artista> getAll(Connection con) {
        List<Artista> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.ALL.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    Artista n = ArtistaDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Artista");
        }
        return result;
    }

    public static List<Artista> getByName(Connection con, String name) {
        List<Artista> result = new ArrayList<>();
        try {
          
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.FINDBYNAME.getQ(), name + "%");
            if (rs != null) {
                while (rs.next()) {
                    Artista n = ArtistaDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Artista");
        }
        return result;
    }

    public static List<Artista> getById(Connection con, List<Integer> ids) {
        List<Artista> result = new ArrayList<>();
        try {
            List<String> newList = new ArrayList<String>(ids.size());
            for (Integer myInt : ids) {
                newList.add(String.valueOf(myInt));
            }
            String queryTotal = queries.GETBYID.getQ() + "(" + String.join(",", newList) + ");";

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queryTotal, null);
            if (rs != null) {
                while (rs.next()) {
                    Artista n = ArtistaDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Artista");
        }
        return result;
    }


}


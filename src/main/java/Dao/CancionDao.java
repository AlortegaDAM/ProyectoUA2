/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Carlos
 */
import Control.JDBCConector;
import com.mycompany.proyectoua2.model.Cancion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class CancionDao extends Cancion implements Dao{
    
    enum queries {
        INSERT("INSERT INTO cancion (ID,Nombre,Duracion,ID_Genero,ID_Disco) VALUES (?,?,?,?)"),
        ALL("SELECT * FROM cancion"),
        GETBYID("SELECT * FROM cancion WHERE id=?"),
        FINDBYNAME("SELECT * FROM cancion WHERE nombre LIKE ?"),
        UPDATE("UPDATE cancion SET Nombre = ?, Duracion = ? WHERE id = ?"),
        REMOVE("DELETE FROM cancion WHERE id=?");
        private String q;

        queries(String q) {
            this.q = q;
        }

        public String getQ() {
            return this.q;
        }
    }
     JDBCConector conex = new JDBCConector();

    Connection con;
    private boolean persist;

    public CancionDao(int id, String nombre, int duracion, int ID_Genero, int ID_Disco) {
        super(id, nombre, duracion, ID_Genero, ID_Disco);
        
        con = conex.createNewDBconnection();
    }

    public CancionDao() {
        super();
        con = conex.createNewDBconnection();
        persist = false;
    }

    //DAO
    public CancionDao(Cancion a) {
        this(a.getId(), a.getNombre(), a.getDuracion(), a.getId_disco(),a.getId_genero());
    }

    public CancionDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, CancionDao.queries.GETBYID.getQ(), params);

            if (rs != null) {

                while (rs.next()) {
                    Cancion c = instanceBuilder(rs);
                    this.id = c.getId();
                    this.nombre = c.getNombre();
                    this.id_disco = c.getId_disco();
                    this.id_genero = c.getId_genero();
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Cancion");
        }
    }

    public void persist() {
        this.persist = true;
    }

    public void detach() {
        this.persist = false;
    }

  

  

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
        if (persist) {
            save();
        }
    }

     @Override
    public void setDuracion(int duracion) {
        super.setDuracion(duracion);
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
        CancionDao.queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getNombre());
        params.add(this.getDuracion());
        params.add(this.getId_disco());
        params.add(this.getId_genero());
        

        if (this.id == -1) {
            q = CancionDao.queries.INSERT;
        } else {
            q = CancionDao.queries.UPDATE;
            params.add(this.id);
        }

        try {
            //Comienza transacción
            con.setAutoCommit(false);

            int rs = Util.ConnectionUtil.execUpdate(con, q.getQ(), params, (q == CancionDao.queries.INSERT ? true : false));
            if (q == CancionDao.queries.INSERT) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar cancion");
        }

    }

    public void remove() {
        if (this.id != -1) {
            try {
                //Comienza transacción
                con.setAutoCommit(false);

                int rs = Util.ConnectionUtil.execUpdate(con, CancionDao.queries.REMOVE.getQ(), this.id, false);

                //Fin de la transacción
                con.commit();
                con.setAutoCommit(true);

            } catch (SQLException ex) {
                System.out.println("Error al borrar cancion");
            }
        }
    }

    // UTILS for CONTACT DAO
    public static Cancion instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        Cancion c = new Cancion();
        if (rs != null) {
            try {
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("Nombre"));
                c.setDuracion(rs.getInt("Duracion"));
                c.setId_disco(rs.getInt("ID_Disco"));
                c.setId_genero(rs.getInt("ID_Genero"));
               
                //falta lazy contacts
            } catch (SQLException ex) {
                System.out.println("Error SQL al crear un cancion");

            }

        }
        return c;
    }

    public static List<Cancion> getAll(Connection con) {
        List<Cancion> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, CancionDao.queries.ALL.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    Cancion n = CancionDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar cancion");
        }
        return result;
    }

    public static List<Cancion> getByName(Connection con, String name) {
        List<Cancion> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, CancionDao.queries.FINDBYNAME.getQ(), name + "%");
            if (rs != null) {
                while (rs.next()) {
                    Cancion n = CancionDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Cancion");
        }
        return result;
    }

    public static List<Cancion> getById(Connection con, List<Integer> ids) {
        List<Cancion> result = new ArrayList<>();
        try {
            List<String> newList = new ArrayList<String>(ids.size());
            for (Integer myInt : ids) {
                newList.add(String.valueOf(myInt));
            }
            String queryTotal = CancionDao.queries.GETBYID.getQ() + "(" + String.join(",", newList) + ");";

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queryTotal, null);
            if (rs != null) {
                while (rs.next()) {
                    Cancion n = CancionDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar cancion");
        }
        return result;
    }
    
}

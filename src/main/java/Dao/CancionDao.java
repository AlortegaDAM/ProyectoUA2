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
import com.mycompany.proyectoua2.model.Lista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class CancionDao extends Cancion implements Dao{
    
    enum queries {
        INSERT("INSERT INTO cancion (Nombre,Duracion,ID_Disco) VALUES (?,?,?)"),
        ALL("SELECT * FROM cancion"),
        GETBYID("SELECT * FROM cancion WHERE ID=?"),
        FINDBYNAME("SELECT * FROM cancion WHERE Nombre LIKE ?"),
        UPDATE("UPDATE cancion SET Nombre = ?, Duracion = ? WHERE ID = ?"),
        UPDATEARTISTID("UPDATE cancion SET Artista_ID = ?, ID = ?"),
        REMOVE("DELETE FROM cancion WHERE ID=?");
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

    public CancionDao(String nombre, int duracion, int ID_Disco) {
        super(nombre, duracion, ID_Disco);
        
        con = conex.createNewDBconnection();
    }

    public CancionDao() {
        super();
        con = conex.createNewDBconnection();
        persist = false;
    }

    //DAO
    public CancionDao(Cancion a) {
        this(a.getNombre(), a.getDuracion(), a.getId_disco());
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
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Cancion");
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
    
    

    @Override
    public void save() {
        CancionDao.queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getNombre());
        params.add(this.getDuracion());
        params.add(this.getId_disco());
        

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
            ex.printStackTrace();
            System.out.println("Error al guardar cancion");
        }

    }

    @Override
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
                c.setId(rs.getInt("ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setDuracion(rs.getInt("Duracion"));
                c.setId_disco(rs.getInt("ID_Disco"));
                
               
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

    public static Cancion getById(Connection con, int id) {
        Cancion result = new Cancion();
        String consulta = "SELECT * FROM cancion where id =?";
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                result.setId(rs.getInt("ID"));
                result.setNombre(rs.getString("Nombre"));
                result.setDuracion(rs.getInt("Duracion"));
                result.setId_disco(rs.getInt("ID_Disco"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al cargar lista");
        }
        return result;
    }
    
    
}

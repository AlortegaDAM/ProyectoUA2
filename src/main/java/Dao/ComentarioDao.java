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
import com.mycompany.proyectoua2.model.Comentario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ComentarioDao extends Comentario implements Dao{
     enum queries {
        INSERT("INSERT INTO comentario (ID,Mensaje,ID_Usuario,ID_Lista) VALUES (?,?,?,?)"),
        ALL("SELECT * FROM comentario"),
        GETBYID("SELECT * FROM comentario WHERE ID=?"),
        FINDBYNAME("SELECT * FROM comentario WHERE Mensaje LIKE ?"),
        UPDATE("UPDATE comentario SET Mensaje = ? WHERE ID = ?"),
        REMOVE("DELETE FROM comentario WHERE ID=?");
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

    public ComentarioDao(int ID, String mensaje, int ID_Usuario, int ID_Lista) {
        super(ID, mensaje, ID_Usuario, ID_Lista);
        
        con = conex.createNewDBconnection();
    }

    public ComentarioDao() {
        super();
        con = conex.createNewDBconnection();
        persist = false;
    }

    //DAO
    public ComentarioDao(Comentario a) {
        this(a.getId(), a.getMensaje(), a.getID_Lista(), a.getID_Usuario());
    }

    public ComentarioDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, ComentarioDao.queries.GETBYID.getQ(), params);

            if (rs != null) {

                while (rs.next()) {
                    Comentario c = instanceBuilder(rs);
                    this.id = c.getId();
                    this.mensaje = c.getMensaje();
                    this.ID_Lista = c.getID_Lista();
                    this.ID_Usuario = c.getID_Usuario();
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
    public void setMensaje(String mensaje) {
        super.setMensaje(mensaje);
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
        ComentarioDao.queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getMensaje());
        params.add(this.getID_Lista());
        params.add(this.getID_Usuario());
      
        

        if (this.id == -1) {
            q = ComentarioDao.queries.INSERT;
        } else {
            q = ComentarioDao.queries.UPDATE;
            params.add(this.id);
        }

        try {
            //Comienza transacción
            con.setAutoCommit(false);

            int rs = Util.ConnectionUtil.execUpdate(con, q.getQ(), params, (q == ComentarioDao.queries.INSERT ? true : false));
            if (q == ComentarioDao.queries.INSERT) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar comentario");
        }

    }

    public void remove() {
        if (this.id != -1) {
            try {
                //Comienza transacción
                con.setAutoCommit(false);

                int rs = Util.ConnectionUtil.execUpdate(con, ComentarioDao.queries.REMOVE.getQ(), this.id, false);

                //Fin de la transacción
                con.commit();
                con.setAutoCommit(true);

            } catch (SQLException ex) {
                System.out.println("Error al borrar cancion");
            }
        }
    }

    // UTILS for CONTACT DAO
    public static Comentario instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        Comentario c = new Comentario();
        if (rs != null) {
            try {
                c.setId(rs.getInt("ID"));
                c.setMensaje(rs.getString("Mensaje"));
                c.setID_Lista(rs.getInt("ID_Lista"));
                c.setID_Usuario(rs.getInt("ID_Usuario"));
                
               
                //falta lazy contacts
            } catch (SQLException ex) {
                System.out.println("Error SQL al crear un Comentario");

            }

        }
        return c;
    }

    public static List<Comentario> getAll(Connection con) {
        List<Comentario> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, ComentarioDao.queries.ALL.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    Comentario n = ComentarioDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Comentario");
        }
        return result;
    }

    public static List<Comentario> getByName(Connection con, String name) {
        List<Comentario> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, ComentarioDao.queries.FINDBYNAME.getQ(), name + "%");
            if (rs != null) {
                while (rs.next()) {
                    Comentario n = ComentarioDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Comentario");
        }
        return result;
    }

    public static List<Comentario> getById(Connection con, List<Integer> ids) {
        List<Comentario> result = new ArrayList<>();
        try {
            List<String> newList = new ArrayList<String>(ids.size());
            for (Integer myInt : ids) {
                newList.add(String.valueOf(myInt));
            }
            String queryTotal = ComentarioDao.queries.GETBYID.getQ() + "(" + String.join(",", newList) + ");";

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queryTotal, null);
            if (rs != null) {
                while (rs.next()) {
                    Comentario n = ComentarioDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Comentario");
        }
        return result;
    }
}


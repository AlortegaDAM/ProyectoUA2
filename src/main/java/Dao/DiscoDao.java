/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import Control.JDBCConector;
import com.mycompany.proyectoua2.model.Disco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class DiscoDao extends Disco implements Dao{

    enum queries {
        INSERT("INSERT INTO disco (ID,Nombre,Foto,Fecha_publicacion,ID_Artista) VALUES (?,?,?,?,?)"),
        ALL("SELECT * FROM disco"),
        GETBYID("SELECT * FROM disco WHERE ID=?"),
        FINDBYNAME("SELECT * FROM disco WHERE Nombre LIKE ?"),
        UPDATE("UPDATE disco SET Nombre = ?, Foto = ?, Fecha_publicacion= ? WHERE id = ?"),
        REMOVE("DELETE FROM disco WHERE ID=?");
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

    public DiscoDao(int id, String nombre, String foto, int id_artista, LocalDate fecha_produccion) {
        super(id,nombre,foto,id_artista,fecha_produccion);
        con = conex.createNewDBconnection();
        persist = false;
    }

    public DiscoDao() {
        super();
        con = conex.createNewDBconnection();

        persist = false;
    }

    //DAO
    public DiscoDao(Disco a) {
        this(a.getId(), a.getNombre(), a.getFoto(), a.getId_artista(), a.getFecha_produccion());
    }

    public DiscoDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.GETBYID.getQ(), params);

            if (rs != null) {

                while (rs.next()) {
                    Disco c = instanceBuilder(rs);
                    this.id = c.getId();
                    this.nombre = c.getNombre();
                    this.fecha_produccion = c.getFecha_produccion();
                    this.foto = c.getFoto();
                    this.id_artista = c.getId_artista();
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Disco");
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
    public void setFecha_produccion(LocalDate fecha_produccion) {
        super.setFecha_produccion(fecha_produccion);
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
        params.add(this.getFecha_produccion());
        params.add(this.getId_artista());
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
            if (q == DiscoDao.queries.INSERT) {
                this.id = rs;
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error al guardar Disco");
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
                System.out.println("Error al borrar Disco");
            }
        }
    }

    // UTILS for CONTACT DAO
    public static Disco instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        Disco c = new Disco();
        if (rs != null) {
            try {
                c.setId(rs.getInt("ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setFecha_produccion( rs.getDate("Fecha_publicacion").toLocalDate());
                c.setId_artista(rs.getInt("ID_Artista"));

                //falta lazy contacts
            } catch (SQLException ex) {
                System.out.println("Error SQL al crear un Disco");

            }

        }
        return c;
    }

    public static List<Disco> getAll(Connection con) {
        List<Disco> result = new ArrayList<>();
        try {
            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.ALL.getQ(), null);
            if (rs != null) {
                while (rs.next()) {
                    Disco n = DiscoDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Disco");
        }
        return result;
    }

    public static List<Disco> getByName(Connection con, String name) {
        List<Disco> result = new ArrayList<>();
        try {

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queries.FINDBYNAME.getQ(), name + "%");
            if (rs != null) {
                while (rs.next()) {
                    Disco n = DiscoDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Disco");
        }
        return result;
    }

    public static List<Disco> getById(Connection con, List<Integer> ids) {
        List<Disco> result = new ArrayList<>();
        try {
            List<String> newList = new ArrayList<String>(ids.size());
            for (Integer myInt : ids) {
                newList.add(String.valueOf(myInt));
            }
            String queryTotal = queries.GETBYID.getQ() + "(" + String.join(",", newList) + ");";

            ResultSet rs = Util.ConnectionUtil.execQuery(con, queryTotal, null);
            if (rs != null) {
                while (rs.next()) {
                    Disco n = DiscoDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar Disco");
        }
        return result;
    }

}


package JDBCControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConector {
    
    Connection conn;
    final String url="jdbc:mysql://localhost:3306/musica";
    final String user="root";
    final String pass="";
    final String timezone="?useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public Connection createNewDBconnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url+timezone, user, pass);
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger("DBcon").log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    return conn;
    }   
}

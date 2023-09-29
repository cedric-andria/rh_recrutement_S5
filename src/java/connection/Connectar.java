/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author P14A-10-Cedric
 */
public class Connectar {
Connection connection;

    // public Connectar() {
    //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }

    public Connection getConnection() {
        return connection;
    }
    
    public Connectar() throws ClassNotFoundException, SQLException{
        connection=null;
        try {
            URLConnection con=new Postgresql(5432,"smartmarket");
            String user="postgres",password="caeyla01";
            Class.forName(con.getDriver());
            connection=DriverManager.getConnection(con.getUrl(), user, password);
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("le driver n'est pas valide");
            //Logger.getLogger(Connectar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            throw new SQLException("Erreur SQL");
            //Logger.getLogger(Connectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connectar(String url,String driver,String user,String psid,boolean commit) throws ClassNotFoundException, SQLException{
        connection=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,psid);
            connection.setAutoCommit(commit);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("driver non retrouver");
            //Logger.getLogger(Connectar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            throw new SQLException("Erreur sql");
            //Logger.getLogger(Connectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void close() throws SQLException{
        this.connection.close();
    }
}

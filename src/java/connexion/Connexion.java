package connexion;

import java.sql.*;

public class Connexion {
    
    public Connection connexPostgres() throws Exception{
      
        Class.forName("org.postgresql.Driver");
        Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/baserecrutement", "baserecrutement", "baserecrutement");
        
        return co;
    }

    public Connection connectPostgre() throws Exception
    {
        Connexion c = new Connexion();
        Connection co = c.connexPostgres();

        return co;
    }

}

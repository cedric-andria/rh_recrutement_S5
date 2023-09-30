/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author P14A-10-Cedric
 */
import java.sql.*;

public class ConnectionJava {
    private String driver;
    private String url;
    private String utilisateur;
    private String mdp;
    public ConnectionJava(String drv, String url1, String utilisateur, String mdp)
    { 
            this.driver=drv;
            this.url=url1;
            this.utilisateur=utilisateur;
            this.mdp=mdp;
    }
    public Connection connect() throws Exception
    {
            Connection con = null;
            try
            {
                    Class.forName(this.driver);
                    con=DriverManager.getConnection(this.url,this.utilisateur,this.mdp);
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    throw e;
            }


    return con;

    }

    public void setdriver(String driver)
    {
            this.driver = driver;
    }

    public String getdriver()
    {
            return this.driver;
    }

    public void seturl(String url)
    {
            this.url = url;
    }

    public String geturl()
    {
            return this.url;
    }

    public void setutilisateur(String utilisateur)
    {
            this.utilisateur = utilisateur;
    }

    public String getutilisateur()
    {
            return this.utilisateur;
    }

    public void setmdp(String mdp)
    {
            this.mdp = mdp;
    }

    public String getmdp()
    {
            return this.mdp;
    }
}

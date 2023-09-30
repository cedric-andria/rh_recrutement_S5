package modele;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class ResponsableService {
    
    private int id;
    private int id_service;
    private int id_responsable;

    public ResponsableService()
    {

    }

    public ResponsableService(int id, int id_service, int id_responsable)
    {
        setId(id);
        setId_service(id_service);
        setId_responsable(id_responsable);
    }

    public ResponsableService getResponsableService(Connection c, int id)throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        ResponsableService responsable = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM responsable_service WHERE id_responsable = " + id;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()){
            responsable = new ResponsableService(resultat.getInt(1), resultat.getInt(2), resultat.getInt(3));
        }

        c.close();

        return responsable;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public int getId_responsable() {
        return id_responsable;
    }
    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }
}

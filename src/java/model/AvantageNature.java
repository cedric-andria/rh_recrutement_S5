package model;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class AvantageNature {
    
    private int id;
    private int id_employe;
    private int id_avantage;

    public AvantageNature()
    {

    }

    public AvantageNature(int id, int idEmploye, int idAvantage)
    {
        setId(id);
        setId_employe(idEmploye);
        setId_avantage(idAvantage);
    }

    public void insertAvantageNature(Connection c, AvantageNature av) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO avantage_nature VALUES(default, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, av.getId_employe());
        preparedStatement.setInt(2, av.getId_avantage());

        int result = preparedStatement.executeUpdate();

        c.close();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_employe() {
        return id_employe;
    }
    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }
    public int getId_avantage() {
        return id_avantage;
    }
    public void setId_avantage(int id_avantage) {
        this.id_avantage = id_avantage;
    }

}

package model;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class Avantage {

    private int id;
    private String nom;

    public Avantage()
    {

    }

    public Avantage(int id, String nom)
    {
        setId(id);
        setNom(nom);
    }

    public Vector<Avantage> getAllAvantage(Connection c) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        Vector<Avantage> allAvantage = new Vector<Avantage>();
        Avantage temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM avantage";
        ResultSet resultat = st.executeQuery(requette);

        while(resultat.next()) {
            temp = new Avantage(resultat.getInt(1), resultat.getString(2));
            allAvantage.add(temp);
        }

        c.close();

        return allAvantage;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}

package modele;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import connexion.Connexion;

public class Poste {
    
    private int id;
    private String nom;
    private int id_service;


    public Poste()
    {

    }

    public Poste(int id, String nom, int id_service)
    {
        setId(id);
        setNom(nom);
        setId_service(id_service);
    }

    public Vector<Poste> getAllPoste(Connection c) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        Vector<Poste> allPoste = new Vector<Poste>();
        Poste temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM poste";
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()){
            temp = new Poste(resultat.getInt(1), resultat.getString(2), resultat.getInt(3));
            allPoste.add(temp);
        }

        c.close();

        return allPoste;
    }

    public Vector<Poste> getAllPosteByService(Connection c, int idResponsableService) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        Vector<Poste> allPoste = new Vector<Poste>();
        Poste temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM V_poste_by_service WHERE id_responsable = " + idResponsableService;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()){
            temp = new Poste(resultat.getInt(2), resultat.getString(3), resultat.getInt(4));
            allPoste.add(temp);
        }

        c.close();

        return allPoste;
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

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }


}

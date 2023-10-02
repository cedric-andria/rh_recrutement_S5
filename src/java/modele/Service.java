package modele;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import connexion.Connexion;

public class Service {

    private int id;
    private String nom;

    public Service()
    {

    }

    public Service(int id, String nom) 
    {
        setId(id);
        setNom(nom);
    }

    public Vector<Service> getAllService(Connection c) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        Vector<Service> allService= new Vector<Service>();
        Service temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM service";
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()){
            temp = new Service(resultat.getInt(1), resultat.getString(2));
            allService.add(temp);
        }


        return allService;
    }

    public void insertBesoinService(Connection c, int id_service, int id_poste, int nbr, double volumeHoraire) throws Exception
    {
        
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO besoin_service VALUES (default, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, id_service);
        preparedStatement.setInt(2, id_poste);
        preparedStatement.setInt(3, nbr);
        preparedStatement.setDouble(4, volumeHoraire);

        int result = preparedStatement.executeUpdate();

        c.close();
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

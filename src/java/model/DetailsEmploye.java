package model;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class DetailsEmploye {
    private int id;
    private int id_employe;
    private String adresse;
    private String nom_prenom_pere;
    private String nom_prenom_mere;
    private String numero_cin;


    public DetailsEmploye()
    {

    }

    public DetailsEmploye(int id, int idEmploye, String adresse, String nomPrenomPere, String nomPrenomMere, String numeroCin)
    {
        setId(id);
        setId_employe(idEmploye);
        setAdresse(adresse);
        setNom_prenom_pere(nomPrenomPere);
        setNom_prenom_mere(nomPrenomMere);
        setNumero_cin(numeroCin);
    }

    public void insertDetailsEmploye(Connection c, DetailsEmploye detailsEmp) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO details_employe VALUES(default, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, detailsEmp.getId_employe());
        preparedStatement.setString(2, detailsEmp.getAdresse());
        preparedStatement.setString(3, detailsEmp.getNom_prenom_pere());
        preparedStatement.setString(4, detailsEmp.getNom_prenom_mere());
        preparedStatement.setString(5, detailsEmp.getNumero_cin());

        int result = preparedStatement.executeUpdate();

        c.close();

    }

    public Vector<DetailsEmploye> getDetailsEmployes(Connection c, String filaharana) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<DetailsEmploye> allDetailsEmployes = new Vector<DetailsEmploye>();
        DetailsEmploye temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM details_employe ORDER BY ID "+ filaharana;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new DetailsEmploye(resultat.getInt(1), resultat.getInt(2), resultat.getString(3), resultat.getString(4), resultat.getString(5), resultat.getString(6));
            allDetailsEmployes.add(temp);
        }

        c.close();

        return allDetailsEmployes;
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
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getNom_prenom_pere() {
        return nom_prenom_pere;
    }
    public void setNom_prenom_pere(String nom_prenom_pere) {
        this.nom_prenom_pere = nom_prenom_pere;
    }
    public String getNom_prenom_mere() {
        return nom_prenom_mere;
    }
    public void setNom_prenom_mere(String nom_prenom_mere) {
        this.nom_prenom_mere = nom_prenom_mere;
    }
    public String getNumero_cin() {
        return numero_cin;
    }
    public void setNumero_cin(String numero_cin) {
        this.numero_cin = numero_cin;
    }
}

package model;

import java.sql.Date;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class ContratEssaie {
    
    private int id;
    private int id_employe;
    private String numero_matricule;
    private Date date_debut;
    private Date date_fin;
    private double salaire;
    private String lieu_travail;

    public ContratEssaie()
    {

    }

    public ContratEssaie(int id, int idEmploye, String numeroMatricule, Date dateDebut, Date dateFin, double salaire, String lieuTravail)
    {
        setId(id);
        setId_employe(idEmploye);
        setNumero_matricule(numeroMatricule);
        setDate_debut(dateDebut);
        setDate_fin(dateFin);
        setSalaire(salaire);
        setLieu_travail(lieuTravail);
    }

    public void insertContratEssaie(Connection c, ContratEssaie contratEssaie) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO contrat_essaie VALUES(default, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, contratEssaie.getId_employe());
        preparedStatement.setString(2, contratEssaie.getNumero_matricule());
        preparedStatement.setDate(3, contratEssaie.getDate_debut());
        preparedStatement.setDate(4, contratEssaie.getDate_fin());
        preparedStatement.setDouble(5, contratEssaie.getSalaire());
        preparedStatement.setString(6, contratEssaie.getLieu_travail());

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
    public String getNumero_matricule() {
        return numero_matricule;
    }
    public void setNumero_matricule(String numero_matricule) {
        this.numero_matricule = numero_matricule;
    }
    public Date getDate_debut() {
        return date_debut;
    }
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }
    public Date getDate_fin() {
        return date_fin;
    }
    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public String getLieu_travail() {
        return lieu_travail;
    }
    public void setLieu_travail(String lieu_travail) {
        this.lieu_travail = lieu_travail;
    }

}

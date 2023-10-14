package model;

import java.sql.Date;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private int sexe;
    private String mail;

    public Employe()
    {

    }

    public Employe(int id, String nom, String prenom, Date dateNaissance, int sexe, String mail)
    {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setDate_naissance(dateNaissance);
        setSexe(sexe);
        setMail(mail);
    }

    public String idChar(int taille, String prefix, String sequence)
    {
        StringBuffer idPers = new StringBuffer(prefix);
        char[] s = sequence.toCharArray();
        int longeur = taille-s.length;
        for(int i = 0; i < longeur; i++)
        {
            idPers.append(0);
            if(i == longeur-1)
            {
                idPers.append(sequence);
            }
            
        }

        String l = idPers.toString();

        return l;
    }

    public void insertEmploye(Connection c, Employe emp) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO employe VALUES(default, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setString(1, emp.getNom());
        preparedStatement.setString(2, emp.getPrenom());
        preparedStatement.setDate(3, emp.getDate_naissance());
        preparedStatement.setInt(4, emp.getSexe());
        preparedStatement.setString(5, emp.getMail());

        int result = preparedStatement.executeUpdate();

        c.close();
    }

    public Vector<Employe> getEmployes(Connection c, String filaharana) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<Employe> allEmployes = new Vector<Employe>();
        Employe temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM employ ORDER BY ID "+ filaharana;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new Employe(resultat.getInt(1), resultat.getString(2), resultat.getString(3), resultat.getDate(4), resultat.getInt(5), resultat.getString(6));
            allEmployes.add(temp);
        }

        c.close();

        return allEmployes;
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
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDate_naissance() {
        return date_naissance;
    }
    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }
    public int getSexe() {
        return sexe;
    }
    public void setSexe(int sexe) {
        this.sexe = sexe;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}

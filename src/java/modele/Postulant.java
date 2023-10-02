package modele;

import java.sql.Date;
import java.sql.Statement;
import java.sql.Connection;
import connexion.Connexion;
import java.sql.ResultSet;


public class Postulant {

    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private int sexe;
    private String mail;
    private String mdp;
    
    public Postulant()
    {
        
    }

    public Postulant(int id, String nom, String prenom, 
                        Date dateNaissance, int sexe, 
                        String mail, String mdp)
    {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setDate_naissance(dateNaissance);
        setSexe(sexe);
        setMail(mail);
        setMdp(mdp);
    }


    public Postulant getPostulant(Connection c, String mail, String mdp) throws Exception
    {

        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        Postulant postulant = null;

        Statement st = c.createStatement();
        String requette = "select * from postulant where mail = '"+ mail +"' and mdp = '" + mdp +"'";
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()){
            postulant = new Postulant(resultat.getInt(1), resultat.getString(2), 
                                        resultat.getString(3), resultat.getDate(4), 
                                        resultat.getInt(5), resultat.getString(6), 
                                        resultat.getString(7));
        }

        c.close();
        
        return postulant;
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}

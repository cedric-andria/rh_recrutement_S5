package modele;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class Annonce {
    
    private int id;
    private int id_poste;

    //V_annonce
    private String nom_poste;
    private int debut_exp;
    private int fin_exp;
    private String langue;
    private String diplome;

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Annonce()
    {

    }

    public Annonce(int id, int idPoste)
    {
        setId(id);
        setId_poste(idPoste);
    }

    public Annonce(String nomPoste, int debutExp, int finExp, String langue, String diplome)
    {
        setNom_poste(nomPoste);
        setDebut_exp(debutExp);
        setFin_exp(finExp);
        setLangue(langue);
        setDiplome(diplome);
    }

    public Vector<Annonce> getAllAnnonce(Connection c) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        Vector<Annonce> allAnnonce = new Vector<Annonce>();
        Annonce temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM V_annonce";
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()){
            temp = new Annonce(resultat.getString(1), resultat.getInt(2), resultat.getInt(3), resultat.getString(4), resultat.getString(5));
            allAnnonce.add(temp);
        }

        c.close();

        return allAnnonce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }

    public String getNom_poste() {
        return nom_poste;
    }

    public void setNom_poste(String nom_poste) {
        this.nom_poste = nom_poste;
    }

    public int getDebut_exp() {
        return debut_exp;
    }

    public void setDebut_exp(int debut_exp) {
        this.debut_exp = debut_exp;
    }

    public int getFin_exp() {
        return fin_exp;
    }

    public void setFin_exp(int fin_exp) {
        this.fin_exp = fin_exp;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getDiplome() {
        return diplome;
    }

}

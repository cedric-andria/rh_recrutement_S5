package model;

import java.sql.Statement;
import java.util.Vector;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class ReponsePostulant {
    
    private int id;
    private int id_postulant;
    private int id_test;
    private int id_question;
    private int reponse;


    public ReponsePostulant()
    {

    }

    public ReponsePostulant(int id, int idPostulant, int idTest, int idQuestion, int reponse)
    {
        setId(id);
        setId_postulant(idPostulant);
        setId_test(idTest);
        setId_question(idQuestion);
        setReponse(reponse);
    }

    public void insertReponsePostulant(Connection c, ReponsePostulant repPostulant) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO reponse_postulant VALUES(default, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, repPostulant.getId_postulant());
        preparedStatement.setInt(2, repPostulant.getId_test());
        preparedStatement.setInt(3, repPostulant.getId_question());
        preparedStatement.setInt(4, repPostulant.getReponse());

        int result = preparedStatement.executeUpdate();

        c.close();
    }

    public Vector<ReponsePostulant> getReponsePostulant(Connection c, int idPostulant, int idQuestion) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<ReponsePostulant> allRep = new Vector<ReponsePostulant>();
        ReponsePostulant temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM reponse_postulant WHERE ID_POSTULANT = " + idPostulant + " AND ID_QUESTION = " + idQuestion;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new ReponsePostulant(resultat.getInt(1), resultat.getInt(2), resultat.getInt(3), resultat.getInt(4), resultat.getInt(5));
            allRep.add(temp);
        }

        return allRep;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_postulant() {
        return id_postulant;
    }
    public void setId_postulant(int id_postulant) {
        this.id_postulant = id_postulant;
    }
    public int getId_question() {
        return id_question;
    }
    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
    public int getReponse() {
        return reponse;
    }
    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }
}

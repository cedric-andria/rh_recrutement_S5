package model;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class ReponseTest {
    
    private int id;
    private int id_question;
    private String reponse;
    private int etat;


    public ReponseTest()
    {

    }

    public ReponseTest(int id, int idQuestion, String reponse, int etat)
    {
        setId(id);
        setId_question(idQuestion);
        setReponse(reponse);
        setEtat(etat);
    }

    public void insertReponseTest(Connection c, ReponseTest rt) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO reponse_test VALUES(default, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, rt.getId_question());
        preparedStatement.setString(2, rt.getReponse());
        preparedStatement.setInt(3, rt.getEtat());

        int result = preparedStatement.executeUpdate();

        c.close();
    }

    public Vector<ReponseTest> getReponseTestByQuestion(Connection c, int idQuestion) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<ReponseTest> allReponse = new Vector<ReponseTest>();
        ReponseTest temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM reponse_test WHERE id_question = " + idQuestion;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new ReponseTest(resultat.getInt(1), resultat.getInt(2), resultat.getString(3), resultat.getInt(4));
            allReponse.add(temp);
        }

        return allReponse;

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_question() {
        return id_question;
    }
    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
    public String getReponse() {
        return reponse;
    }
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

}

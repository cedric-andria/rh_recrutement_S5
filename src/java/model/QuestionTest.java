package model;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class QuestionTest {

    private int id;
    private int id_test;
    private String question;
    private int coefficient;

    //V_question_poste
    private int id_question;
    private int id_poste;

    
    public QuestionTest()
    {

    }

    public QuestionTest(int id, int idTest, String questio, int coefficient)
    {
        setId(id);
        setId_test(idTest);
        setQuestion(questio);
        setCoefficient(coefficient);
    }

    public QuestionTest(int idQuestion, String question, int coefficient, int idPoste)
    {
        setId_question(idQuestion);
        setQuestion(question);
        setCoefficient(coefficient);
        setId_poste(idPoste);
    }

    public void insertQuestionTest(Connection c, QuestionTest qt) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        String requette = "INSERT INTO question_test VALUES(default, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, qt.getId_test());
        preparedStatement.setString(2, qt.getQuestion());
        preparedStatement.setInt(3, qt.getCoefficient());

        int result = preparedStatement.executeUpdate();

        c.close();
    }

    public Vector<QuestionTest> getQuestionTestByTest(Connection c, int idTest) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<QuestionTest> allQuestion = new Vector<QuestionTest>();
        QuestionTest temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM question_test WHERE id_test = " + idTest;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new QuestionTest(resultat.getInt(1), resultat.getInt(2), resultat.getString(3), resultat.getInt(4));
            allQuestion.add(temp);
        }

        return allQuestion;

    }

    public Vector<QuestionTest> getQuestionTestByPoste(Connection c, int idPoste) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<QuestionTest> allQuestion = new Vector<QuestionTest>();
        QuestionTest temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM V_question_poste WHERE id_poste = " + idPoste;
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new QuestionTest(resultat.getInt(1), resultat.getString(2), resultat.getInt(3), resultat.getInt(4));
            allQuestion.add(temp);
        }

        return allQuestion;

    }

    public int nbQuestion(Connection c) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        int nb = 0;

        Statement st = c.createStatement();
        String requette = "select id from question_test ORDER BY id DESC LIMIT 1";
        ResultSet resultat = st.executeQuery(requette);

        while(resultat.next()) {
            nb = resultat.getInt(1);
        }

        return nb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

   
    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }


}
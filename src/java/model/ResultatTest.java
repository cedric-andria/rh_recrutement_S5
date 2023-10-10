package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connexion.Connexion;

public class ResultatTest {
    
    private int id;
    private int id_postulant;
    private double note;
    private Date date;

    // V_resultat_test
    private String nom;
    private String prenom;


    public ResultatTest()
    {

    }

    public ResultatTest(int id, int idPostulant, double note, Date date)
    {
        setId(id);
        setId_postulant(idPostulant);
        setNote(note);
        setDate(date);
    }

    public ResultatTest(int id, double note, Date date, String nom, String prenom)
    {
        setId(id);
        setNote(note);
        setDate(date);
        setNom(nom);
        setPrenom(prenom);
    }

    public double calculNotePostulant(Connection c, int idTest, int idPostulant) throws Exception
    {

        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        double note = 0;

        QuestionTest qt = new QuestionTest();
        Vector<QuestionTest> allQt = qt.getQuestionTestByTest(c, idTest);
        ReponsePostulant repPostulant = new ReponsePostulant();

        
        for(int i = 0; i < allQt.size(); i++)
        {
            int countTrueTest = 0;
            int countTruePostulant = 0;
            ReponseTest repTest = new ReponseTest();
            Vector<ReponseTest> allRepTest = repTest.getReponseTestByQuestion(c, allQt.get(i).getId());
            Vector<ReponsePostulant> allRepPostulant = repPostulant.getReponsePostulant(c, idPostulant, allQt.get(i).getId());

            for(int j = 0; j < allRepTest.size(); j++)
            {
                if(allRepTest.get(j).getEtat() == 1)
                {
                    countTrueTest++;

                    for(int k = 0; k < allRepPostulant.size(); k++)
                    {
                        if(allRepPostulant.get(k).getReponse() == allRepTest.get(j).getId())
                        {
                            countTruePostulant++;
                        }
                    }
                    
                }
                
            }

            if(countTrueTest == countTruePostulant)
            {
                note = note + allQt.get(i).getCoefficient();
            }
        }

        
        return note;
    }

    public void insertReponseTest(Connection c, int idTest, int idPostulant) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }

        double note = calculNotePostulant(c, idTest, idPostulant);

        String requette = "INSERT INTO resultat_test VALUES(default, ?, ?, NOW())";
        PreparedStatement preparedStatement = c.prepareStatement(requette);
        preparedStatement.setInt(1, idPostulant);
        preparedStatement.setDouble(2, note);

        int result = preparedStatement.executeUpdate();

        c.close();
    }

    public Vector<ResultatTest> getResultatTest(Connection c) throws Exception
    {
        if(c == null)
        {
            Connexion co = new Connexion();
            c = co.connectPostgre();
        }
        Vector<ResultatTest> result = new Vector<ResultatTest>();
        ResultatTest temp = null;

        Statement st = c.createStatement();
        String requette = "SELECT * FROM V_resultat_test ORDER BY note DESC LIMIT 5";
        ResultSet resultat = st.executeQuery(requette);
        while(resultat.next()) {
            temp = new ResultatTest(resultat.getInt(1), resultat.getDouble(2), resultat.getDate(3), resultat.getString(4), resultat.getString(5));
            result.add(temp);
        }


        return result;
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
    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
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
}

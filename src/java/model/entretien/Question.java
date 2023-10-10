package model.entretien;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Question {
    private int id;
    private int id_entretien;
    private int id_poste;
    private String question;
    private double coefficient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_entretien() {
        return id_entretien;
    }

    public void setId_entretien(int id_entretien) {
        this.id_entretien = id_entretien;
    }


    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void insert(Connection connection) throws Exception {
        boolean ouvert = false;
        if (connection == null) {
            connection = new PostgreSQL(
                    "localhost",
                    "5432",
                    "recrutement",
                    "postgres",
                    "root")
                    .getConnection();
            ouvert = true;
        }
        String sql = "insert into question_entretien values (default, '"
                .concat(String.valueOf(id_entretien))
                .concat("', '")
                .concat(String.valueOf(id_poste))
                .concat("', '")
                .concat(question)
                .concat("', '")
                .concat(String.valueOf(coefficient))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }

    public Vector<Question> getQuestionByEntretien(Connection connection, int id_entretien) throws Exception {
        boolean ouvert = false;
        if (connection == null) {
            connection = new PostgreSQL(
                    "localhost",
                    "5432",
                    "recrutement",
                    "postgres",
                    "root")
                    .getConnection();
            ouvert = true;
        }

        Vector<Question> questions = new Vector<>();
        String sql = "SELECT * FROM question_entretien WHERE id = ".concat(String.valueOf(id_entretien));
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Question question = new Question();
            question.setId(resultSet.getInt("id"));
            question.setId_poste(resultSet.getInt("id_poste"));
            question.setQuestion(resultSet.getString("question"));
            question.setCoefficient(resultSet.getDouble("coefficient"));
            questions.add(question);
        }
        if (ouvert) {
            connection.close();
        }
        return questions;
    }
}

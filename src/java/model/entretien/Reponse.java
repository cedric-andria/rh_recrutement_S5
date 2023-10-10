package model.entretien;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Reponse {
    private int id;
    private int id_question;
    private String reponse;
    private int etat;

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
        String sql = "insert into reponse_entretien values (default, '"
                .concat(String.valueOf(id_question))
                .concat("', '")
                .concat(reponse)
                .concat("', '")
                .concat(String.valueOf(etat))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
    public Vector<Reponse> getReponseByQuestion(Connection connection, int id_question) throws Exception {
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

        Vector<Reponse> reponses = new Vector<>();
        String sql = "SELECT * FROM reponse_entretien WHERE id_question = ".concat(String.valueOf(id_question));
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Reponse reponse = new Reponse();
            reponse.setId(resultSet.getInt("id"));
            reponse.setId_question(resultSet.getInt("id_question"));
            reponse.setReponse(resultSet.getString("reponse"));
            reponse.setEtat(resultSet.getInt("etat"));
            reponses.add(reponse);
        }
        if (ouvert) {
            connection.close();
        }
        return reponses;
    }
}

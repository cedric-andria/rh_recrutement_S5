package model.entretien;

import util.PostgreSQL;

import java.sql.Connection;

public class Reponse_entretien_postulant {
    private int id;
    private int id_entretien;
    private int id_postulant;
    private int id_question;
    private String reponse;

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

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
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
        String sql = "insert into reponse_entretien_postulant values (default, '"
                .concat(String.valueOf(id_entretien))
                .concat("', '")
                .concat(String.valueOf(id_postulant))
                .concat("', '")
                .concat(String.valueOf(id_question))
                .concat("', '")
                .concat(reponse)
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
}

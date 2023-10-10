package model.entretien;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Resultat {
    private int id_entretien;
    private int id_postulant;
    private double note;

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

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
    public Vector<Resultat> getResultatByEntretien (Connection connection, int id_entretien) throws Exception {
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
        String sql = "SELECT * FROM resultat_entretien WHERE id_entretien = "
            .concat(String.valueOf(id_entretien));
        System.out.println(sql);
        Vector<Resultat> resultats = new Vector<>();
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Resultat resultat = new Resultat();
            resultat.setId_entretien(resultSet.getInt("id_entretien"));
            resultat.setId_postulant(resultSet.getInt("id_postulant"));
            resultat.setNote(resultSet.getDouble("note"));
            resultats.add(resultat);
        }
        if (ouvert) {
            connection.close();
        }
        return resultats;
    }
}

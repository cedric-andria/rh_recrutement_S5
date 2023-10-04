package model;

import util.PostgreSQL;

import java.sql.Connection;

public class Coeff_diplome_service {
    private int id;
    private int id_poste;
    private int id_diplome;
    private double note;

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

    public int getId_diplome() {
        return id_diplome;
    }

    public void setId_diplome(int id_diplome) {
        this.id_diplome = id_diplome;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
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
        String sql = "insert into coeff_diplome_service values (default, '"
                .concat(String.valueOf(id_poste))
                .concat("', '")
                .concat(String.valueOf(id_diplome))
                .concat("', '")
                .concat(String.valueOf(note))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
}

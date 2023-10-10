package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;

public class Entretien {
    private int id;
    private int id_poste;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        String sql = "insert into entretien values (default, '"
                .concat(String.valueOf(id_poste))
                .concat("', '")
                .concat(String.valueOf(date))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
    public Entretien getEntretienById(Connection connection, int id_entretien) throws Exception {
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
        Entretien entretien = new Entretien();
        String sql = "SELECT * FROM entretien WHERE id = "
                .concat(String.valueOf(id_entretien));
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            entretien.setId(resultSet.getInt("id"));
            entretien.setId_poste(resultSet.getInt("id_poste"));
            entretien.setDate(resultSet.getDate("date"));
        }
        if (ouvert) {
            connection.close();
        }
        return entretien;
    }
}

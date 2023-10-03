package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;

public class Poste {
    private int id;
    private String nom;
    private int id_service;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
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
        String sql = "insert into poste values ( default, '"
                .concat(nom)
                .concat("', '")
                .concat(String.valueOf(id_service))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }

    public Poste getPoste(Connection connection) throws Exception {
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
        String sql = "SELECT * FROM poste WHERE id_service = '"
                .concat(String.valueOf(id_service))
                .concat("' AND nom = '")
                .concat(nom)
                .concat("'");
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            this.setId(resultSet.getInt("id"));
            this.setNom(resultSet.getString("nom"));
            this.setId_service(resultSet.getInt("id_service"));
        }
        if (ouvert) {
            connection.close();
        }
        return this;
    }
}

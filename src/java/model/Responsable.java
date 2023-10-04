package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;

public class Responsable {
    private int id;
    private String nom;
    private String mdp;

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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
        String sql = "insert into responsable values ( default, '"
                .concat(nom)
                .concat("', '")
                .concat(mdp)
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
    public Responsable getResponsable(Connection connection) throws Exception {
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
        String sql = "SELECT * FROM responsable WHERE nom = '".concat(nom).concat("' AND mdp = '").concat(mdp).concat("'");
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            this.setId(resultSet.getInt("id"));
            this.setNom(resultSet.getString("nom"));
            this.setMdp(resultSet.getString("mdp"));
        }
        if (ouvert) {
            connection.close();
        }
        return this;
    }
}

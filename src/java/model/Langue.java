package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Langue {
    private int id;
    private String nom;

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
    public Vector<Langue> getAll(Connection connection) throws Exception {
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
        Vector<Langue> langues = new Vector<>();
        String sql = "SELECT * FROM langue";
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Langue langue = new Langue();
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            langue.setId(id);
            langue.setNom(nom);
            langues.add(langue);
        }
        if (ouvert) {
            connection.close();
        }
        return langues;
    }
}

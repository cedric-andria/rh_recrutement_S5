package model;

import dao.ObjetBdd;
import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Diplome extends ObjetBdd<Diplome>{
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
    public Vector<Diplome> getAll(Connection connection) throws Exception {
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
        Vector<Diplome> diplomes = new Vector<>();
        String sql = "SELECT * FROM diplome";
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Diplome diplome = new Diplome();
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            diplome.setId(id);
            diplome.setNom(nom);
            diplomes.add(diplome);
        }
        if (ouvert) {
            connection.close();
        }
        return diplomes;
    }
}

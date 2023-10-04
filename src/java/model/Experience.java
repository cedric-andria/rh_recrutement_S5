package model;

import dao.ObjetBdd;
import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Experience extends ObjetBdd<Experience>{
    private int id;
    private int debut;
    private int fin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    public Vector<Experience> getAll(Connection connection) throws Exception {
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
        Vector<Experience> experiences = new Vector<>();
        String sql = "SELECT * FROM experience";
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Experience experience = new Experience();
            int id = resultSet.getInt("id");
            int debut = resultSet.getInt("debut");
            int fin = resultSet.getInt("fin");
            experience.setId(id);
            experience.setDebut(debut);
            experience.setFin(fin);
            experiences.add(experience);
        }
        if (ouvert) {
            connection.close();
        }
        return experiences;
    }
}

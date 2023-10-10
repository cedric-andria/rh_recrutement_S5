package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Employe {
    private int id;
    private int id_postulant;
    private int id_poste;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_postulant() {
        return id_postulant;
    }

    public void setId_postulant(int id_postulant) {
        this.id_postulant = id_postulant;
    }

    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
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
        String sql = "insert into question_entretien values (default, '"
                .concat(String.valueOf(id_postulant))
                .concat("', '")
                .concat(String.valueOf(id_poste))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
    public Vector<Employe> getAllByPoste(Connection connection, int id_poste) throws Exception {
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
        Vector<Employe> employes = new Vector<>();
        String sql = "SELECT * FROM employe WHERE id_poste = "
                .concat(String.valueOf(id_poste));
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Employe employe = new Employe();
            employe.setId(resultSet.getInt("id"));
            employe.setId_postulant(resultSet.getInt("id_postulant"));
            employe.setId_poste(resultSet.getInt("id_poste"));
            employes.add(employe);
        }
        if (ouvert) {
            connection.close();
        }
        return employes;
    }
}

package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;

public class Responsable_service {
    private int id;
    private int id_service;
    private int id_responsable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
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
        String sql = "insert into responsable_service values (default, '"
                .concat(String.valueOf(id_service))
                .concat("', '")
                .concat(String.valueOf(id_responsable))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
    public Responsable_service getResponsable_service(Connection connection) throws Exception {
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
        String sql = "SELECT * FROM responsable_service WHERE id_responsable = '"
                .concat(String.valueOf(id_responsable))
                .concat("'");
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            this.setId(resultSet.getInt("id"));
            this.setId_responsable(resultSet.getInt("id_responsable"));
            this.setId_service(resultSet.getInt("id_service"));
        }
        if (ouvert) {
            connection.close();
        }
        return this;
    }
}

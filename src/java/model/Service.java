package model;

import util.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Service {
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

    public Vector<Service> getAll(Connection connection) throws Exception {
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
        Vector<Service> services = new Vector<>();
        String sql = "SELECT * FROM service";
        System.out.println(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Service service = new Service();
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            service.setId(id);
            service.setNom(nom);
            services.add(service);
        }
        if (ouvert) {
            connection.close();
        }
        return services;
    }
}

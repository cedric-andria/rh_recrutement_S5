package util;

import java.sql.*;

public class Connexion {
    Connection connection;
    public Connexion () {

    }
    public Connexion(String driver, String type, String host, String port, String database, String user, String password) throws Exception {
        Class.forName(driver);
        String url = "jdbc:" + type + "://" + host + ":" + port + "/" + database;
        try {
            this.setConnection(DriverManager.getConnection(url, user, password));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
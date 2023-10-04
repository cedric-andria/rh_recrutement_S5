package util;

import java.sql.Connection;

public class PostgreSQL extends Connexion {
    public static Connection connection;
    public PostgreSQL() {

    }
    public PostgreSQL(String host, String port, String database, String user, String password) throws Exception {
        super("org.postgresql.Driver","postgresql", host, port, database, user, password);
        connection = super.getConnection();
    }
}

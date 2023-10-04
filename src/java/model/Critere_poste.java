package model;

import util.PostgreSQL;

import java.sql.Connection;

public class Critere_poste {
    private int id;
    private int id_poste;
    private int id_diplome;
    private int id_langue;
    private int id_experience;
    private int sexe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }

    public int getId_diplome() {
        return id_diplome;
    }

    public void setId_diplome(int id_diplome) {
        this.id_diplome = id_diplome;
    }

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }

    public int getId_experience() {
        return id_experience;
    }

    public void setId_experience(int id_experience) {
        this.id_experience = id_experience;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
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
        String sql = "insert into critere_poste values ( default, '"
                .concat(String.valueOf(id_poste))
                .concat("', '")
                .concat(String.valueOf(id_diplome))
                .concat("', '")
                .concat(String.valueOf(id_langue))
                .concat("', '")
                .concat(String.valueOf(id_experience))
                .concat("', '")
                .concat(String.valueOf(sexe))
                .concat("')");
        System.out.println(sql);
        connection.createStatement().execute(sql);
        if (ouvert) {
            connection.close();
        }
    }
}

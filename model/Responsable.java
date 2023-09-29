package model;

import annotation.Constraint;
import annotation.Table;
import util.Model;

@Table
public class Responsable extends Model {
    @Constraint (primaryKey = true)
    private Integer id;
    @Constraint (NULL = false)
    private String nom;
    @Constraint (NULL = false)
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
}

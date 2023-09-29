package model;

import annotation.Constraint;
import annotation.Table;
import util.Model;

@Table
public class Responsable_service extends Model {
    @Constraint (primaryKey = true)
    private
    Integer id;
    @Constraint(foreignKey = true, reference = "service")
    private
    Integer id_service;
    @Constraint(foreignKey = true, reference = "responsable")
    private
    Integer id_responsable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }

    public Integer getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(Integer id_responsable) {
        this.id_responsable = id_responsable;
    }
}

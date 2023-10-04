/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annot.PrimaryKeyAnnotation;
import annot.FkAnnotation;
import dao.ObjetBdd;
import java.util.Date;
import annot.TsyMiditraAnnotation;
/**
 *
 * @author P14A-10-Cedric
 */
public class Cv extends ObjetBdd<Cv>{
    @PrimaryKeyAnnotation
    private int id;
    @FkAnnotation(fieldName="id_poste")
    private Poste poste;
    @FkAnnotation(fieldName="id")
    private Postulant postulant;
    @FkAnnotation(fieldName="id")
    private Diplome diplome;
//    @FkAnnotation(fieldName="id")
//    private Langue langue;
    @FkAnnotation(fieldName="id")
    private Experience experience;
    private int resident;
    private Date date;
    @TsyMiditraAnnotation
    private Langue[] langues;
    

    public Cv() {
    }

    public Cv(int id) {
        this.setId(id);
    }

//    public Cv(Poste poste, Postulant postulant, Diplome diplome, Langue langue, Experience experience, int resident, Date date) {
//        this.setPoste(poste);
//        this.setPostulant(postulant);
//        this.setDiplome(diplome);
//        this.setLangue(langue);
//        this.setExperience(experience);
//        this.setResident(resident);
//        this.setDate(date);
//    }

    public Cv(Poste poste, Postulant postulant, Diplome diplome, Experience experience, int resident, Date date, Langue[] langues) {
        this.setPoste(poste);
        this.setPostulant(postulant);
        this.setDiplome(diplome);
        this.setExperience(experience);
        this.setResident(resident);
        this.setDate(date);
        this.setLangues(langues);
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

//    public Langue getLangue() {
//        return langue;
//    }
//
//    public void setLangue(Langue langue) {
//        this.langue = langue;
//    }

    public Langue[] getLangues() {
        return langues;
    }

    public void setLangues(Langue[] langues) {
        this.langues = langues;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public int getResident() {
        return resident;
    }

    public void setResident(int resident) {
        this.resident = resident;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
